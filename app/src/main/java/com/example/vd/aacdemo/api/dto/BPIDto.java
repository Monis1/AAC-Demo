package com.example.vd.aacdemo.api.dto;

import com.example.vd.aacdemo.model.Currency;

public class BPIDto {

    private Currency USD;
    private Currency GBP;
    private Currency EUR;

    public Currency getUSD() {
        return USD;
    }

    public void setUSD(Currency USD) {
        this.USD = USD;
    }

    public Currency getGBP() {
        return GBP;
    }

    public void setGBP(Currency GBP) {
        this.GBP = GBP;
    }

    public Currency getEUR() {
        return EUR;
    }

    public void setEUR(Currency EUR) {
        this.EUR = EUR;
    }
}
