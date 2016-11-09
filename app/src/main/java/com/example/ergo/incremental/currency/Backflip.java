package com.example.ergo.incremental.currency;

import com.example.ergo.incremental.utils.CurrencyNames;

public class Backflip implements Currency, CurrencyNames {
    protected String name;

    public Backflip(){
        name = BACKFLIP_NOM;
    }

    public String getName() {
        return name;
    }
}
