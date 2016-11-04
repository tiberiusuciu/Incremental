package com.example.ergo.incremental.currency;

import com.example.ergo.incremental.utils.CurrencyNames;

public class DarkSouls implements Currency, CurrencyNames {
    protected String name;

    public DarkSouls(){
        name = DARKSOULS_NOM;
    }

    public String getName() {
        return name;
    }
}
