package com.example.ergo.incremental.model.currency;

import com.example.ergo.incremental.model.utils.CurrencyNames;

public class Anime implements Currency, CurrencyNames {
    protected String name;

    public Anime(){
        name = ANIME_NOM;
    }

    public String getName() {
        return name;
    }
}
