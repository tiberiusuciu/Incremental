package com.example.ergo.incremental.model;

import com.example.ergo.incremental.model.utils.UserStats;

/**
 * Cette Class représente l'usager principale, c'est ici où
 * on prend en compte tout les travaileurs ainsi que la
 * monnaie qu'on possède
 */

public class User implements UserStats {
    protected Wallet wallet;
    protected Team team;
    protected int codesPerSecond;
    protected int codesPerTap;

    public User(){
        codesPerSecond = STARTING_CODES_PER_SECOND;
        codesPerTap = STARTING_CODES_PER_TAP;
        wallet = new Wallet();
        team = new Team();
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

    public void addFarmer(Team.Programmers p) {
        team.addProgrammer(p, 1);
        calculateCodesPerSecond();
    }

    public int countAllInstancesOfSpecificFarmer(Team.Programmers p) {
        return team.getAmountOfProgrammers(p);
    }

    public void calculateCodesPerSecond() {
        setCodesPerSecond(team.calculateCPSFromTeam());
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
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

    public void resetWallet() {
        wallet.reset();
    }

    public void resetTeam() {
        team.reset();
    }
}
