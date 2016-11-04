package com.example.ergo.incremental.farmer;

import com.example.ergo.incremental.farmer.Farmer;
import com.example.ergo.incremental.utils.FarmersStats;

public class DavidFarmer implements Farmer, FarmersStats {
    private int codesPerSeconds;
    private String name;

    public DavidFarmer() {
        codesPerSeconds = DAVIDE_CPS;
        name = DAVIDE_NAME;
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
