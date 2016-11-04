package com.example.ergo.incremental.farmer;

import com.example.ergo.incremental.farmer.Farmer;
import com.example.ergo.incremental.utils.FarmersStats;

public class DavideFarmer implements Farmer, FarmersStats {

    private int codesPerSeconds = DAVIDE_CPS;

    @Override
    public int getCodesPerSeconds() {
        return this.codesPerSeconds;
    }

    @Override
    public void setCodesPerSeconds(int newCodesPerSecond) {
        this.codesPerSeconds = newCodesPerSecond;
    }
}
