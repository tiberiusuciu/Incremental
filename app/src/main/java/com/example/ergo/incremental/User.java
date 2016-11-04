package com.example.ergo.incremental;

import com.example.ergo.incremental.currency.Currency;
import com.example.ergo.incremental.farmer.Farmer;
import com.example.ergo.incremental.utils.UserStats;

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
        monnaie = null;
        travaileurs = null;
        codesPerSecond = startingCodesPerSecond;
        codesPerTap = startingCodesPerTap;
    }

    public void addMonnaie(Currency c) {
        this.monnaie.add(c);
    }

    public void addFarmer(Farmer f) {
        this.travaileurs.add(f);
        calculateCodesPerSecond();
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
        this.codesPerTap = codesPerTap;
    }
}
