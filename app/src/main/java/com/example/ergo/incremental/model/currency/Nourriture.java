package com.example.ergo.incremental.model.currency;

import com.example.ergo.incremental.model.utils.CurrencyNames;

public class Nourriture implements Currency, CurrencyNames {
    protected String name;

    public Nourriture(){
        name = NOURRITURE_NOM;
    }

    public String getName() {
        return name;
    }
}
