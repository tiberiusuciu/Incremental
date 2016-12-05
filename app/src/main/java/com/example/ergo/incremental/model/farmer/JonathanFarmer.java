package com.example.ergo.incremental.model.farmer;

import com.example.ergo.incremental.model.utils.FarmersStats;

public class JonathanFarmer implements Farmer, FarmersStats {
    private int codesPerSeconds;
    private String name;

    public JonathanFarmer() {
        codesPerSeconds = JONATHAN_CPS;
        name = JONATHAN_NAME;
    }

    @Override
    public int getCodesPerSeconds() {
        return this.codesPerSeconds;
    }

    @Override
    public void setCodesPerSeconds(int newCodesPerSecond) {
        this.codesPerSeconds = newCodesPerSecond;
    }

    public String getName() {
        return name;
    }
}