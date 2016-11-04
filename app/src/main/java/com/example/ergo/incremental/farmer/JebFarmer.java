package com.example.ergo.incremental.farmer;

import com.example.ergo.incremental.utils.FarmersStats;

public class JebFarmer implements Farmer, FarmersStats {
    private int codesPerSeconds;
    private String name;

    public JebFarmer() {
        codesPerSeconds = JEB_CPS;
        name = JEB_NAME;
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
