package com.noemi.android.payitforward.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.noemi.android.payitforward.api.model.PaymentMethod;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SharedPref {

    private Context context;
    private SharedPreferences sharedPreferences;
    private Gson gson;

    public SharedPref(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        gson = new Gson();
    }

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    public Gson getGson() {
        return gson;
    }

    public void savePayments(List<PaymentMethod> method){
        getSharedPreferences().edit().putString(Constants.KEY_PAYMENT, getGson().toJson(method)).apply();
    }

    public List<PaymentMethod> getPayments() {
        String json = getSharedPreferences().getString(Constants.KEY_PAYMENT, null);
        Type type = new TypeToken<ArrayList<PaymentMethod>>() {}.getType();
        return getGson().fromJson(json, type);
    }

}
