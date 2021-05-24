package com.noemi.android.payitforward.api.model;

import com.google.gson.annotations.SerializedName;

public class PaymentResponse {

    @SerializedName("networks")
    private AcceptedMethods acceptedMethods;

    public AcceptedMethods getAcceptedMethods() {
        return acceptedMethods;
    }

    public void setAcceptedMethods(AcceptedMethods acceptedMethods) {
        this.acceptedMethods = acceptedMethods;
    }
}
