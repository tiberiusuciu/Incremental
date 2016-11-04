package com.example.ergo.incremental.farmer;

import com.example.ergo.incremental.utils.FarmersStats;


public class NicolasFarmer implements Farmer, FarmersStats {
    private int codesPerSeconds = NICOLAS_CPS;

    @Override
    public int getCodesPerSeconds() {
        return this.codesPerSeconds;
    }

    @Override
    public void setCodesPerSeconds(int newCodesPerSecond) {
        this.codesPerSeconds = newCodesPerSecond;
    }
}
