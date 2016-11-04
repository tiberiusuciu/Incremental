package com.example.ergo.incremental.farmer;

import com.example.ergo.incremental.utils.FarmersStats;


public class MiechkoFarmer implements Farmer, FarmersStats {
    private int codesPerSeconds = MIECHKO_CPS;

    @Override
    public int getCodesPerSeconds() {
        return this.codesPerSeconds;
    }

    @Override
    public void setCodesPerSeconds(int newCodesPerSecond) {
        this.codesPerSeconds = newCodesPerSecond;
    }
}
