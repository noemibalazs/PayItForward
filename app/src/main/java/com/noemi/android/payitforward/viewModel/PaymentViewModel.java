package com.noemi.android.payitforward.viewModel;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.noemi.android.payitforward.api.model.PaymentMethod;
import com.noemi.android.payitforward.api.model.PaymentResponse;
import com.noemi.android.payitforward.api.remoteDataSource.PaymentRepository;
import com.noemi.android.payitforward.util.SharedPref;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class PaymentViewModel extends AndroidViewModel {

    private static final String TAG = PaymentViewModel.class.getSimpleName();
    private PaymentRepository paymentRepository;
    private SharedPref sharedPref;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MutableLiveData<List<PaymentMethod>> paymentList = new MutableLiveData<>();
    private MutableLiveData<Boolean> progressEvent = new MutableLiveData<>();
    private MutableLiveData<String> errorEvent = new MutableLiveData<>();

    public PaymentViewModel(Application application) {
        super(application);
        this.paymentRepository = PaymentRepository.getInstance();
        this.sharedPref = new SharedPref(application.getApplicationContext());
    }

    public void getPaymentMethods() {
        compositeDisposable.clear();
        Disposable disposable = paymentRepository.getPaymentMethods()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally(new Action() {
                    @Override
                    public void run() throws Exception {
                        progressEvent.setValue(false);
                    }
                })
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        progressEvent.setValue(true);
                    }
                })
                .subscribeWith(new DisposableSingleObserver<PaymentResponse>() {

                    @Override
                    public void onSuccess(@NonNull PaymentResponse paymentResponse) {
                        Log.d(TAG, "onSuccess() response size: " + paymentResponse.getAcceptedMethods().getPaymentMethodList().size());
                        List<PaymentMethod> paymentMethods = paymentResponse.getAcceptedMethods().getPaymentMethodList();
                        paymentList.setValue(paymentMethods);
                        sharedPref.savePayments(paymentMethods);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError() message: " + e.getMessage());
                        errorEvent.setValue("An error has occurred.");
                    }
                });
        compositeDisposable.add(disposable);
    }

    public LiveData<Boolean> getProgressEvent() {
        return progressEvent;
    }

    public LiveData<String> getErrorEvent() {
        return errorEvent;
    }

    public LiveData<List<PaymentMethod>> getPaymentMethodList() {
        return paymentList;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }
}