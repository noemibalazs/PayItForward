package com.noemi.android.payitforward.api.remoteData;

import io.reactivex.Single;
import retrofit2.http.GET;
import com.noemi.android.payitforward.api.model.PaymentResponse;

public interface PaymentAPI {

   @GET("listresult.json")
    Single<PaymentResponse> getPaymentMethods();
}
