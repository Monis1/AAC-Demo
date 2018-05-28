package com.example.vd.aacdemo.repository;

import android.arch.lifecycle.LiveData;
import android.util.Log;

import com.example.vd.aacdemo.BasicApp;
import com.example.vd.aacdemo.api.ApiClient;
import com.example.vd.aacdemo.api.BPApi;
import com.example.vd.aacdemo.api.dto.CoinPriceDto;
import com.example.vd.aacdemo.constants.AppConstants;
import com.example.vd.aacdemo.db.AppDatabase;
import com.example.vd.aacdemo.model.Currency;

import java.io.IOException;
import java.util.List;

import retrofit2.Response;

public class CurrencyRepository {

    private BPApi bpApi;
    private AppDatabase appDatabase;

    public CurrencyRepository() {
        bpApi = ApiClient.getClient().create(BPApi.class);
        appDatabase = BasicApp.getInstance().getDatabase();
    }

    public LiveData<List<Currency>> getCurrencyData() {
        refreshCurrencyData();
        // return a LiveData directly from the database.
        return appDatabase.currencyDao().loadAll();
    }

    private void refreshCurrencyData() {
        Runnable runnable = () -> {
            Response response;
            try {
                response = bpApi.getCoinPrice().execute();
                CoinPriceDto coinPriceDto = (CoinPriceDto) response.body();
                // TODO check for error etc.
                // Update the database.The LiveData will automatically refresh so
                // we don't need to do anything else here besides updating the database
                if (coinPriceDto != null) {
                    Log.i(AppConstants.LOG_TYPE_INFO, coinPriceDto.getChartName());
                    appDatabase.currencyDao().save(coinPriceDto.getBpi().getUSD());
                    appDatabase.currencyDao().save(coinPriceDto.getBpi().getEUR());
                    appDatabase.currencyDao().save(coinPriceDto.getBpi().getGBP());
                }
            } catch (IOException e) {
                Log.e(AppConstants.LOG_TYPE_ERROR, e.getMessage());
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

}
