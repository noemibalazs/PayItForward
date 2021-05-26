package com.noemi.android.payitforward.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class PaymentLogo implements Parcelable {

    @SerializedName("logo")
    private String logo;

    protected PaymentLogo(Parcel in) {
        logo = in.readString();
    }

    public static final Creator<PaymentLogo> CREATOR = new Creator<PaymentLogo>() {
        @Override
        public PaymentLogo createFromParcel(Parcel in) {
            return new PaymentLogo(in);
        }

        @Override
        public PaymentLogo[] newArray(int size) {
            return new PaymentLogo[size];
        }
    };

    public PaymentLogo(String logo) {
        this.logo = logo;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentLogo that = (PaymentLogo) o;
        return Objects.equals(logo, that.logo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logo);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(logo);
    }
}
