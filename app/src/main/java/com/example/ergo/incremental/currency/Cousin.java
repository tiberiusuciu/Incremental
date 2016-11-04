package com.example.ergo.incremental.currency;

import com.example.ergo.incremental.utils.CurrencyNames;

public class Cousin implements Currency, CurrencyNames {
    protected String name;

    public Cousin(){
        name = COUSIN_NOM;
    }

    public String getName() {
        return name;
    }
}
