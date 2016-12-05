package com.example.ergo.incremental.model.currency;

import com.example.ergo.incremental.model.utils.CurrencyNames;

public class Absence implements Currency, CurrencyNames {
    protected String name;

    public Absence(){
        name = ABSENCE_NOM;
    }

    public String getName() {
        return name;
    }
}
