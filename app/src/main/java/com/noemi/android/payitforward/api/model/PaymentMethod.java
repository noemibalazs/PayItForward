package com.noemi.android.payitforward.api.model;

import com.google.gson.annotations.SerializedName;

public class PaymentMethod {

    @SerializedName("code")
    private String code;

    @SerializedName("label")
    private String name;

    @SerializedName("method")
    private String method;

    @SerializedName("links")
    private PaymentLogo logo;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public PaymentLogo getLogo() {
        return logo;
    }

    public void setLogo(PaymentLogo logo) {
        this.logo = logo;
    }
}
