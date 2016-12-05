package com.example.ergo.incremental.model.farmer;

import com.example.ergo.incremental.model.utils.FarmersStats;


public class MiechkoFarmer implements Farmer, FarmersStats {
    private int codesPerSeconds;
    private String name;

    public MiechkoFarmer() {
        codesPerSeconds = MIECHKO_CPS;
        name = MIECHKO_NAME;
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
