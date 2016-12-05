package com.example.ergo.incremental.model;

import com.example.ergo.incremental.model.currency.Currency;
import com.example.ergo.incremental.model.farmer.Farmer;
import com.example.ergo.incremental.model.utils.UserStats;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette Class représente l'usager principale, c'est ici où
 * on prend en compte tout les travaileurs ainsi que la
 * monnaie qu'on possède
 */

public class User implements UserStats {
    protected List<Currency> monnaie;
    protected List<Farmer> travaileurs;
    protected int codesPerSecond;
    protected int codesPerTap;
    public User(){
        monnaie = new ArrayList<Currency>();
        travaileurs = new ArrayList<Farmer>();
        codesPerSecond = STARTING_CODES_PER_SECOND;
        codesPerTap = STARTING_CODES_PER_TAP;
    }

    public void addMonnaie(Currency c) {
        this.monnaie.add(c);
    }

    public int countAllInstancesOfSpecificMonnaie(String currencyName) {
        int amountFound = 0;
        for(Currency iterator: monnaie) {
            if(iterator.getName().equals(currencyName)){
                amountFound++;
            }
        }
        return amountFound;
    }

    public boolean findSpecificAmountMonnaie(String currencyName, int amountNeeded) {
        int amountFound = 0;
        for(Currency iterator: monnaie) {
            if(iterator.getName().equals(currencyName)){
                amountFound++;
                if(amountFound >= amountNeeded) {
                    return true;
                }
            }
        }
        return false;
    }

    public void removeSpecificAmountMonnaie(String currencyName, int requestedAmount) {
        if(findSpecificAmountMonnaie(currencyName, requestedAmount)){
            int amountDeleted = 0;
            ArrayList toRemove = new ArrayList();
            for (Currency cur : this.monnaie) {
                if (cur.getName().equals(currencyName) && amountDeleted < 2) {
                    toRemove.add(cur);
                    amountDeleted++;
                }
            }
            this.monnaie.removeAll(toRemove);
        }
    }

    public void addFarmer(Farmer f) {
        this.travaileurs.add(f);
        calculateCodesPerSecond();
    }

    public int countAllInstancesOfSpecificFarmer(String farmerName) {
        int amountFound = 0;
        for(Farmer farmer: travaileurs) {
            if(farmer.getName().equals(farmerName)) {
                amountFound++;
            }
        }
        return amountFound;
    }

    public void calculateCodesPerSecond() {
        int newCodesPerSecond = 0;
        for (Farmer farmer : travaileurs) {
            newCodesPerSecond += farmer.getCodesPerSeconds();
        }
        setCodesPerSecond(newCodesPerSecond);
    }

    public List<Currency> getMonnaie() {
        return monnaie;
    }

    public void setMonnaie(List<Currency> monnaie) {
        this.monnaie = monnaie;
    }

    public List<Farmer> getTravaileurs() {
        return travaileurs;
    }

    public void setTravaileurs(List<Farmer> travaileurs) {
        this.travaileurs = travaileurs;
    }

    public int getCodesPerSecond() {
        return codesPerSecond;
    }

    public void setCodesPerSecond(int codesPerSecond) {
        this.codesPerSecond = codesPerSecond;
    }

    public int getCodesPerTap() {
        return codesPerTap;
    }

    public void setCodesPerTap(int codesPerTap) {
        if(codesPerTap >= 1) {
            this.codesPerTap = codesPerTap;
        }
    }
}
