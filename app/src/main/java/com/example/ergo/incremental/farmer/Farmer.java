package com.example.ergo.incremental.farmer;

import com.example.ergo.incremental.utils.FarmersStats;

/**
 * Interface générique pour regrouper tout mes travailleurs
 */

public interface Farmer {
    int getCodesPerSeconds();
    void setCodesPerSeconds(int newCodesPerSecond);
    public String getName();
}
