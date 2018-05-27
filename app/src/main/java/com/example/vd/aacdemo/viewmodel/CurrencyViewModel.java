package com.example.vd.aacdemo.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.vd.aacdemo.model.Currency;
import com.example.vd.aacdemo.repository.CurrencyRepository;

import java.util.List;

public class CurrencyViewModel extends ViewModel {

    private LiveData<List<Currency>> currency;
    private CurrencyRepository currencyRepository;

    public CurrencyViewModel() {
        currencyRepository = new CurrencyRepository();
    }

    public void init() {
        if (this.currency != null) {
            return;
        }
        currency = currencyRepository.getCurrencyData();
    }

    public LiveData<List<Currency>> getCurrencyData() {
        return this.currency;
    }

}
