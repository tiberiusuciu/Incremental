package com.example.ergo.incremental.farmer;

import com.example.ergo.incremental.utils.FarmersStats;

public class GregFarmer implements Farmer, FarmersStats {
    private int codesPerSeconds = GREG_CPS;

    @Override
    public int getCodesPerSeconds() {
        return this.codesPerSeconds;
    }

    @Override
    public void setCodesPerSeconds(int newCodesPerSecond) {
        this.codesPerSeconds = newCodesPerSecond;
    }
}
