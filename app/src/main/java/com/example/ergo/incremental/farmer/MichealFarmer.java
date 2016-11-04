package com.example.ergo.incremental.farmer;

import com.example.ergo.incremental.utils.FarmersStats;

public class MichealFarmer implements Farmer, FarmersStats {
    private int codesPerSeconds;
    private String name;

    public MichealFarmer() {
        codesPerSeconds = MICHEAL_CPS;
        name = MICHEAL_NAME;
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