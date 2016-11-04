package com.example.ergo.incremental.currency;

import com.example.ergo.incremental.utils.CurrencyNames;

public class Magic implements Currency, CurrencyNames {
    protected String name;

    public Magic(){
        name = MAGIC_NOM;
    }

    public String getName() {
        return name;
    }
}
