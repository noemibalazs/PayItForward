package com.noemi.android.payitforward.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class PaymentResponse implements Parcelable {

    @SerializedName("networks")
    private AcceptedMethods acceptedMethods;

    protected PaymentResponse(Parcel in) {
        acceptedMethods = in.readParcelable(AcceptedMethods.class.getClassLoader());
    }

    public static final Creator<PaymentResponse> CREATOR = new Creator<PaymentResponse>() {
        @Override
        public PaymentResponse createFromParcel(Parcel in) {
            return new PaymentResponse(in);
        }

        @Override
        public PaymentResponse[] newArray(int size) {
            return new PaymentResponse[size];
        }
    };

    public PaymentResponse(AcceptedMethods acceptedMethods) {
        this.acceptedMethods = acceptedMethods;
    }

    public AcceptedMethods getAcceptedMethods() {
        return acceptedMethods;
    }

    public void setAcceptedMethods(AcceptedMethods acceptedMethods) {
        this.acceptedMethods = acceptedMethods;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(acceptedMethods, i);
    }
}
