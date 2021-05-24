package com.noemi.android.payitforward.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AcceptedMethods {

    @SerializedName("applicable")
    private List<PaymentMethod> paymentMethodList;

    public List<PaymentMethod> getPaymentMethodList() {
        return paymentMethodList;
    }

    public void setPaymentMethodList(List<PaymentMethod> paymentMethodList) {
        this.paymentMethodList = paymentMethodList;
    }
}
