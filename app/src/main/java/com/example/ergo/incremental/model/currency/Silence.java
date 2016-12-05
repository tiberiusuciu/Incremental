package com.example.ergo.incremental.model.currency;

import com.example.ergo.incremental.model.utils.CurrencyNames;

public class Silence implements Currency, CurrencyNames {
    protected String name;

    public Silence(){
        name = SILENCE_NOM;
    }

    public String getName() {
        return name;
    }
}
