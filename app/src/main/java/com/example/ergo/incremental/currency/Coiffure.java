package com.example.ergo.incremental.currency;

import com.example.ergo.incremental.utils.CurrencyNames;

public class Coiffure implements Currency, CurrencyNames {
    protected String name;

    public Coiffure(){
        name = COIFFURE_NOM;
    }

    public String getName() {
        return name;
    }
}
