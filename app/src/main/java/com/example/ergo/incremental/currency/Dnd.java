package com.example.ergo.incremental.currency;

import com.example.ergo.incremental.utils.CurrencyNames;

public class Dnd implements Currency, CurrencyNames {
    protected String name;

    public Dnd(){
        name = DND_NOM;
    }

    public String getName() {
        return name;
    }
}
