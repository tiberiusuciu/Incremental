package com.example.ergo.incremental.farmer;

import com.example.ergo.incremental.utils.FarmersStats;


public class AdamFarmer implements Farmer, FarmersStats {
    private int codesPerSeconds;
    private String name;

    public AdamFarmer() {
        codesPerSeconds = ADAM_CPS;
        name = ADAM_NAME;
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
