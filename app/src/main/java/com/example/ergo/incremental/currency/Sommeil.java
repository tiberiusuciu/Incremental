package com.example.ergo.incremental.currency;

import com.example.ergo.incremental.utils.CurrencyNames;

public class Sommeil implements Currency, CurrencyNames {
    protected String name;

    public Sommeil(){
        name = SOMMEIL_NOM;
    }

    public String getName() {
        return name;
    }
}
