package com.example.ergo.incremental.currency;


import com.example.ergo.incremental.utils.CurrencyNames;

public class Linux implements Currency, CurrencyNames {
    protected String name;

    public Linux(){
        name = LINUX_NOM;
    }

    public String getName() {
        return name;
    }
}
