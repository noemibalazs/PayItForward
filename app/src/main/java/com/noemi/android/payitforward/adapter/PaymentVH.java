package com.noemi.android.payitforward.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.noemi.android.payitforward.R;
import com.noemi.android.payitforward.api.model.PaymentMethod;

public class PaymentVH extends RecyclerView.ViewHolder {
    private AppCompatImageView icon;
    private AppCompatTextView merchant;

    public PaymentVH(@NonNull View itemView) {
        super(itemView);

        merchant = itemView.findViewById(R.id.tvMerchant);
        icon = itemView.findViewById(R.id.ivIcon);
    }

    public void bindPayment(PaymentMethod paymentMethod) {
        merchant.setText(paymentMethod.getName());
        Glide.with(itemView.getContext())
                .load(paymentMethod.getPaymentLogo().getLogo())
                .error(R.drawable.visa)
                .placeholder(R.drawable.visa)
                .into(icon);
    }
}
