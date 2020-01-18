package com.dimadev.exchange_rates.pojo;

import java.io.Serializable;

public class Currency implements Serializable
{
    private double currencyUSD;
    private double currencyEUR;

    public Currency(double currencyUSD, double currencyEUR) {
        this.currencyUSD = currencyUSD;
        this.currencyEUR = currencyEUR;
    }

    public Currency() {
    }

    public double getCurrencyUSD() {
        return currencyUSD;
    }

    public void setCurrencyUSD(double currencyUSD) {
        this.currencyUSD = currencyUSD;
    }

    public double getCurrencyEUR() {
        return currencyEUR;
    }

    public void setCurrencyEUR(double currencyEUR) {
        this.currencyEUR = currencyEUR;
    }
}
