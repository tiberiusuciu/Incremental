package com.example.ergo.incremental.model.currency;

import com.example.ergo.incremental.model.utils.CurrencyNames;

public class Motivation implements Currency, CurrencyNames {
    protected String name;

    public Motivation(){
        name = MOTIVATION_NOM;
    }

    public String getName() {
        return name;
    }
}
