package com.noemi.android.payitforward.api.remoteDataSource;

;
import com.noemi.android.payitforward.api.model.PaymentResponse;
import com.noemi.android.payitforward.api.remoteData.PaymentAPI;
import com.noemi.android.payitforward.api.remoteData.PaymentClient;

import io.reactivex.Single;

public class PaymentRepository {

    private PaymentAPI paymentAPI;
    private static PaymentRepository paymentRepository;

    public PaymentRepository() {
        this.paymentAPI = PaymentClient.getRetrofitInstance().create(PaymentAPI.class);
    }

    public static PaymentRepository getInstance() {
        if (paymentRepository == null) {
            paymentRepository = new PaymentRepository();
        }
        return paymentRepository;
    }

    public Single<PaymentResponse> getPaymentMethods() {
        return paymentAPI.getPaymentMethods();
    }
}
