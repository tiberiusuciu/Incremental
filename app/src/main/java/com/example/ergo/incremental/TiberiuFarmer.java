package com.example.ergo.incremental;

/**
 * Created by ergo on 03/11/16.
 */

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
