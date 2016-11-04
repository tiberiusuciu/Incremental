package com.example.ergo.incremental.currency;

import com.example.ergo.incremental.utils.CurrencyNames;

public class Blink implements Currency, CurrencyNames {
    protected String name;

    public Blink(){
        name = BLINK_NOM;
    }

    public String getName() {
        return name;
    }
}
