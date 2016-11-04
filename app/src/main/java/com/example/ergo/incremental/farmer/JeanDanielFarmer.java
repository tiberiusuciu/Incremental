package com.example.ergo.incremental.farmer;

import com.example.ergo.incremental.utils.FarmersStats;

public class JeanDanielFarmer implements Farmer, FarmersStats {
    private int codesPerSeconds;
    private String name;

    public JeanDanielFarmer() {
        codesPerSeconds = JEAN_DANIEL_CPS;
        name = JEAN_DANIEL_NAME;
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
