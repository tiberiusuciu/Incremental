package com.example.ergo.incremental.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ergo on 10/12/16.
 */

public class Team {
    public enum Programmers { ADAM, DAVID, GREG, GUILLAUME, HERVE, JEANDANIEL, JEB, JESS, JIMMY, JONATHAN,
                            KEVIN, MICHAEL, MIECHKO, NICOLAS, SAMUEL, SEB, SOARES, TIBERIU, VINCENT, XAVIER};

    private static Map<Programmers, Integer> amount = initProgrammersMap();

    private static Farmers farmers = new Farmers();

    private static Map<Programmers, Integer> initProgrammersMap() {
        HashMap<Programmers, Integer> map = new HashMap<>();
        for(Programmers programmers : Programmers.values()){
            map.put(programmers, 0);
        }
        return map;
    }

    public void addProgrammer(Programmers programmers, int amountOfProgrammers) {
        amount.put(programmers, amount.get(programmers) + amountOfProgrammers);
    }

    public void removeRemoveProgrammer(Programmers programmers, int amountOfProgrammers) {
        amount.put(programmers, amount.get(programmers) - amountOfProgrammers);
    }

    public int getAmountOfProgrammers(Programmers programmers){
        return amount.get(programmers);
    }

    public int calculateCPSFromTeam() {
        int total = 0;
        for(Programmers programmer : Programmers.values()){
            total += amount.get(programmer) * farmers.getPerformanceOfProgrammer(programmer);
        }
        return total;
    }

    public int getTotalAmountOfAllProgrammers() {
        int total = 0;
        for(Programmers programmer : Programmers.values()){
            total += getAmountOfProgrammers(programmer);
        }
        return total;
    }

    public void reset() {
        amount = initProgrammersMap();
    }

    public static Map<Programmers, Integer> getAmount() {
        return amount;
    }

    public static void setAmount(Map<Programmers, Integer> amount) {
        Team.amount = amount;
    }
}
