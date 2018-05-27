package com.example.vd.aacdemo.api;

import com.example.vd.aacdemo.api.dto.CoinPriceDto;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BPApi {

    @GET("/v1/bpi/currentprice.json")
    Call<CoinPriceDto> getCoinPrice();

}
