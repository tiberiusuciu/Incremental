package com.example.ergo.incremental.farmer;

import com.example.ergo.incremental.utils.FarmersStats;


public class AdamFarmer implements Farmer, FarmersStats {
    private int codesPerSeconds = ADAM_CPS;

    @Override
    public int getCodesPerSeconds() {
        return this.codesPerSeconds;
    }

    @Override
    public void setCodesPerSeconds(int newCodesPerSecond) {
        this.codesPerSeconds = newCodesPerSecond;
    }
}
