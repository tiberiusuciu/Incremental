package com.example.ergo.incremental.model.currency;

import com.example.ergo.incremental.model.utils.CurrencyNames;

public class CaffeInn implements Currency, CurrencyNames {
    protected String name;

    public CaffeInn(){
        name = CAFFEINN_NOM;
    }

    public String getName() {
        return name;
    }
}
