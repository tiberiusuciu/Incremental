package com.example.ergo.incremental.farmer;

import com.example.ergo.incremental.utils.FarmersStats;

public class GregFarmer implements Farmer, FarmersStats {
    private int codesPerSeconds;
    private String name;

    public GregFarmer() {
        codesPerSeconds = GREG_CPS;
        name = GREG_NAME;
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
