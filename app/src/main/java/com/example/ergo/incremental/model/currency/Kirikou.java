package com.example.ergo.incremental.model.currency;

import com.example.ergo.incremental.model.utils.CurrencyNames;

public class Kirikou implements Currency, CurrencyNames {
    protected String name;

    public Kirikou(){
        name = KIRIKOU_NOM;
    }

    public String getName() {
        return name;
    }
}
