package com.noemi.android.payitforward.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class PaymentLogo {

    @SerializedName("logo")
    private String logo;

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
}
