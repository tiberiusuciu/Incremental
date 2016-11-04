package com.example.ergo.incremental.currency;

import com.example.ergo.incremental.utils.CurrencyNames;

public class Cabaret implements Currency, CurrencyNames {
    protected String name;

    public Cabaret(){
        name = CABARET_NOM;
    }

    public String getName() {
        return name;
    }
}
