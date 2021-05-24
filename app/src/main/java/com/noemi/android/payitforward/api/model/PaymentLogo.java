package com.noemi.android.payitforward.api.model;

import com.google.gson.annotations.SerializedName;

public class PaymentLogo {

    @SerializedName("logo")
    private String logo;

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
