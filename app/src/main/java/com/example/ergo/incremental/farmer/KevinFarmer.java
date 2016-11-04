package com.example.ergo.incremental.farmer;

import com.example.ergo.incremental.utils.FarmersStats;


public class KevinFarmer implements Farmer, FarmersStats {
    private int codesPerSeconds;
    private String name;

    public KevinFarmer() {
        codesPerSeconds = KEVIN_CPS;
        name = KEVIN_NAME;
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
