package com.example.ergo.incremental.model;

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
    protected Wallet wallet;
    protected int[] programmeurs;
    //protected List<Currency> monnaie;
    protected List<Farmer> travaileurs;
    protected int codesPerSecond;
    protected int codesPerTap;

    public User(){
        //monnaie = new ArrayList<Currency>();
        travaileurs = new ArrayList<Farmer>();
        codesPerSecond = STARTING_CODES_PER_SECOND;
        codesPerTap = STARTING_CODES_PER_TAP;
        wallet = new Wallet();
    }

    public void addMonnaie(Wallet.Currency c) {
        this.wallet.addCurrency(c, 1);
    }

    public int countAllInstancesOfSpecificMonnaie(Wallet.Currency c) {
        return wallet.getAmountOfCurrency(c);
    }

    public boolean findSpecificAmountMonnaie(Wallet.Currency c, int amountNeeded) {
        return wallet.getAmountOfCurrency(c) >= amountNeeded;
    }

    public void removeSpecificAmountMonnaie(Wallet.Currency c, int requestedAmount) {
        if(findSpecificAmountMonnaie(c, requestedAmount)){
            wallet.removeCurrency(c, requestedAmount);
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

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
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
