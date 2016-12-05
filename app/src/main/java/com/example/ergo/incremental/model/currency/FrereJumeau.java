package com.example.ergo.incremental.model.currency;

import com.example.ergo.incremental.model.utils.CurrencyNames;

public class FrereJumeau implements Currency, CurrencyNames {
    protected String name;

    public FrereJumeau(){
        name = FRERE_JUMEAU_NOM;
    }

    public String getName() {
        return name;
    }
}
