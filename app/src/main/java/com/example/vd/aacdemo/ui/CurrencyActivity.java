package com.example.vd.aacdemo.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.vd.aacdemo.R;
import com.example.vd.aacdemo.viewmodel.CurrencyViewModel;

public class CurrencyActivity extends AppCompatActivity {

    private CurrencyViewModel currencyViewModel;
    private TextView coinDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);
        coinDescription = findViewById(R.id.coin_description);
        currencyViewModel = ViewModelProviders.of(this).get(CurrencyViewModel.class);
        currencyViewModel.init();
        observeCurrencyData();
    }

    private void observeCurrencyData() {
        currencyViewModel.getCurrencyData().observe(this, currencies -> {
            // update UI
            if (currencies != null) {
                String description = currencies.get(0).getCode() + " : " + currencies.get(0).getRate() + "\n"
                        + currencies.get(1).getCode() + " : " + currencies.get(1).getRate() + "\n"
                        + currencies.get(2).getCode() + " : " + currencies.get(2).getRate();
                coinDescription.setText(description);
            }
        });
    }

}
