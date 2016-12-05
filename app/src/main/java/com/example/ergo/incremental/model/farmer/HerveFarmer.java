package com.example.ergo.incremental.model.farmer;

import com.example.ergo.incremental.model.utils.FarmersStats;

public class HerveFarmer implements Farmer, FarmersStats {
    private int codesPerSeconds;
    private String name;

    public HerveFarmer() {
        codesPerSeconds = HERVE_CPS;
        name = HERVE_NAME;
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
