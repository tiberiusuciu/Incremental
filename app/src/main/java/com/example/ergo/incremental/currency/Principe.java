package com.example.ergo.incremental.currency;


import com.example.ergo.incremental.utils.CurrencyNames;

public class Principe implements Currency, CurrencyNames {
    protected String name;

    public Principe(){
        name = PRINCIPE_NOM;
    }

    public String getName() {
        return name;
    }
}
