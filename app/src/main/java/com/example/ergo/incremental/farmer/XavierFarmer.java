package com.example.ergo.incremental.farmer;

import com.example.ergo.incremental.utils.FarmersStats;


public class XavierFarmer implements Farmer, FarmersStats {
    private int codesPerSeconds;
    private String name;

    public XavierFarmer() {
        codesPerSeconds = XAVIER_CPS;
        name = XAVIER_NAME;
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
