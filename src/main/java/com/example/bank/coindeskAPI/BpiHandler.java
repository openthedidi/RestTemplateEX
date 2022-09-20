package com.example.bank.coindeskAPI;

import com.example.bank.model.Coin;
import org.springframework.stereotype.Component;

@Component
public class BpiHandler {
    private Coin usd;
    private Coin gbp;
    private Coin eur;

    public Coin getUsd() {
        return usd;
    }

    public void setUsd(Coin usd) {
        this.usd = usd;
    }

    public Coin getGbp() {
        return gbp;
    }

    public void setGbp(Coin gbp) {
        this.gbp = gbp;
    }

    public Coin getEur() {
        return eur;
    }

    public void setEur(Coin eur) {
        this.eur = eur;
    }
}
