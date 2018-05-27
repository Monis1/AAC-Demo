package com.example.vd.aacdemo.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.vd.aacdemo.R;
import com.example.vd.aacdemo.constants.AppConstants;
import com.example.vd.aacdemo.viewmodel.CurrencyViewModel;

public class CurrencyActivity extends AppCompatActivity {

    private CurrencyViewModel currencyViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);
        currencyViewModel = ViewModelProviders.of(this).get(CurrencyViewModel.class);
        currencyViewModel.init();
        observeCurrencyData();
    }

    private void observeCurrencyData() {
        currencyViewModel.getCurrencyData().observe(this, currencies -> {
            // update UI
            if (currencies != null)
                Log.i(AppConstants.LOG_TYPE_INFO, currencies.get(0).getCode());
        });
    }

}
