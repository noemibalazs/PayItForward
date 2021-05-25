package com.noemi.android.payitforward.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

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

    public PaymentLogo getPaymentLogo() {
        return logo;
    }

    public void setPaymentLogo(PaymentLogo logo) {
        this.logo = logo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentMethod that = (PaymentMethod) o;
        return Objects.equals(code, that.code) &&
                Objects.equals(name, that.name) &&
                Objects.equals(method, that.method) &&
                Objects.equals(logo, that.logo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, method, logo);
    }
}
