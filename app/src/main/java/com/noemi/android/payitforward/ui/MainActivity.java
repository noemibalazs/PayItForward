package com.noemi.android.payitforward.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.noemi.android.payitforward.R;
import com.noemi.android.payitforward.viewModel.PaymentViewModel;

public class MainActivity extends AppCompatActivity {

    private PaymentViewModel paymentViewModel;
    private ProgressBar progressBar;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        paymentViewModel = ViewModelProviders.of(this).get(PaymentViewModel.class);
        initViews();
        setUpRv();
        initObservers();
    }

    private void initViews() {
        progressBar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.rvPayments);
    }

    private void setUpRv() {
        recyclerView.setHasFixedSize(true);
    }

    private void initObservers() {
        paymentViewModel.getErrorEvent().observe(this, error -> {
            Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        });

        paymentViewModel.getProgressEvent().observe(this, progress -> {
            if (progress) {
                progressBar.setVisibility(View.VISIBLE);
            } else {
                progressBar.setVisibility(View.GONE);
            }
        });
    }
}