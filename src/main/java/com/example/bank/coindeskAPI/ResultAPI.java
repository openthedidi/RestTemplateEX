package com.example.bank.coindeskAPI;

import com.example.bank.model.Coin;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResultAPI {
    private Time time;
    private BpiHandler bpi;
    private String disclaimer;
    private String chartName;

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public BpiHandler getBpi() {
        return bpi;
    }

    public void setBpi(BpiHandler bpi) {
        this.bpi = bpi;
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
}
