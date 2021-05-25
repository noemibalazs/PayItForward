package com.noemi.android.payitforward.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.noemi.android.payitforward.R;
import com.noemi.android.payitforward.api.model.PaymentMethod;

public class PaymentAdapter extends ListAdapter<PaymentMethod, PaymentVH> {

    public PaymentAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public PaymentVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_payment, parent, false);
        return new PaymentVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentVH holder, int position) {
        holder.bindPayment(getItem(position));
    }

    public static final DiffUtil.ItemCallback<PaymentMethod> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<PaymentMethod>() {
                @Override
                public boolean areItemsTheSame(
                        @NonNull PaymentMethod oldMethod, @NonNull PaymentMethod newMethod) {
                    return oldMethod.getMethod().equals(newMethod.getMethod());
                }

                @Override
                public boolean areContentsTheSame(
                        @NonNull PaymentMethod oldMethod, @NonNull PaymentMethod newMethod) {
                    return oldMethod.equals(newMethod);
                }
            };
}
