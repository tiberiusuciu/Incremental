package com.example.ergo.incremental.currency;

import com.example.ergo.incremental.utils.CurrencyNames;

public class Piano implements Currency, CurrencyNames {
    protected String name;

    public Piano(){
        name = PIANO_NOM;
    }

    public String getName() {
        return name;
    }
}
