package com.example.vd.aacdemo.api.dto;

public class CoinPriceDto {

    private TimeDto time;
    private String disclaimer;
    private String chartName;
    private BPIDto bpi;

    public TimeDto getTime() {
        return time;
    }

    public void setTime(TimeDto time) {
        this.time = time;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public String getChartName() {
        return chartName;
    }

    public void setChartName(String chartName) {
        this.chartName = chartName;
    }

    public BPIDto getBpi() {
        return bpi;
    }

    public void setBpi(BPIDto bpi) {
        this.bpi = bpi;
    }
}
