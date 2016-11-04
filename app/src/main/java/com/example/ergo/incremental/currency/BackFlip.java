package com.example.ergo.incremental.currency;

import com.example.ergo.incremental.utils.CurrencyNames;

public class BackFlip implements Currency, CurrencyNames {
    protected String name;

    public BackFlip(){
        name = BACKFLIP_NOM;
    }

    public String getName() {
        return name;
    }
}
