package com.example.ergo.incremental.currency;


import com.example.ergo.incremental.utils.CurrencyNames;

public class Party implements Currency, CurrencyNames {
    protected String name;

    public Party(){
        name = PARTY_NOM;
    }

    public String getName() {
        return name;
    }
}
