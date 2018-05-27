package com.example.vd.aacdemo.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Currency {

    @PrimaryKey
    @NonNull
    private String code;
    private String symbol;
    private String rate;
    private String description;
    private Double rateFloat;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRateFloat() {
        return rateFloat;
    }

    public void setRateFloat(Double rateFloat) {
        this.rateFloat = rateFloat;
    }

}
