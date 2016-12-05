package com.example.ergo.incremental.model.farmer;

import com.example.ergo.incremental.model.utils.FarmersStats;

public class JessFarmer implements Farmer, FarmersStats {
    private int codesPerSeconds;
    private String name;

    public JessFarmer() {
        codesPerSeconds = JESS_CPS;
        name = JESS_NAME;
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
