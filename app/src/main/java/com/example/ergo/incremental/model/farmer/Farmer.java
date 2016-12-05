package com.example.ergo.incremental.model.farmer;

/**
 * Interface générique pour regrouper tout mes travailleurs
 */

public interface Farmer {
    int getCodesPerSeconds();
    void setCodesPerSeconds(int newCodesPerSecond);
    public String getName();
}
