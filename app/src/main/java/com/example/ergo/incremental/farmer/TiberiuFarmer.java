package com.example.ergo.incremental.farmer;

import com.example.ergo.incremental.utils.FarmersStats;

public class TiberiuFarmer implements Farmer, FarmersStats {

    private int codesPerSeconds = TIBERIU_CPS;

    @Override
    public int getCodesPerSeconds() {
        return this.codesPerSeconds;
    }

    @Override
    public void setCodesPerSeconds(int newCodesPerSecond) {
        this.codesPerSeconds = newCodesPerSecond;
    }
}
