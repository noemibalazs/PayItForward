package com.noemi.android.payitforward.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AcceptedMethods implements Parcelable {

    @SerializedName("applicable")
    private List<PaymentMethod> paymentMethodList;

    protected AcceptedMethods(Parcel in) {
        paymentMethodList = in.createTypedArrayList(PaymentMethod.CREATOR);
    }

    public static final Creator<AcceptedMethods> CREATOR = new Creator<AcceptedMethods>() {
        @Override
        public AcceptedMethods createFromParcel(Parcel in) {
            return new AcceptedMethods(in);
        }

        @Override
        public AcceptedMethods[] newArray(int size) {
            return new AcceptedMethods[size];
        }
    };

    public AcceptedMethods(List<PaymentMethod> paymentMethodList) {
        this.paymentMethodList = paymentMethodList;
    }

    public List<PaymentMethod> getPaymentMethodList() {
        return paymentMethodList;
    }

    public void setPaymentMethodList(List<PaymentMethod> paymentMethodList) {
        this.paymentMethodList = paymentMethodList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(paymentMethodList);
    }
}
