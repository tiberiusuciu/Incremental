package com.example.ergo.incremental.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Cette classe regroupe une collection de programmeurs, qu'on peut ajouter et enlever
 */

public class Team {
    public enum Programmers { ADAM, DAVID, GREG, GUILLAUME, HERVE, JEANDANIEL, JEB, JESS, JIMMY, JONATHAN,
                            KEVIN, MICHAEL, MIECHKO, NICOLAS, SAMUEL, SEB, SOARES, TIBERIU, VINCENT, XAVIER};

    private static Map<Programmers, Integer> amount = initProgrammersMap();

    private static ProgrammersPerformance programmersPerformance = new ProgrammersPerformance();

    private static Map<Programmers, Integer> initProgrammersMap() {
        HashMap<Programmers, Integer> map = new HashMap<>();
        for(Programmers programmers : Team.Programmers.values()){
            map.put(programmers, 0);
        }
        return map;
    }

    public void addProgrammer(Programmers programmers, int amountOfProgrammers) {
        amount.put(programmers, amount.get(programmers) + amountOfProgrammers);
    }

    public int getAmountOfProgrammers(Programmers programmers){
        return amount.get(programmers);
    }

    public int calculateCPSFromTeam() {
        int total = 0;
        for(Programmers programmer : Team.Programmers.values()){
            total += amount.get(programmer) * programmersPerformance.getPerformanceOfProgrammer(programmer);
        }
        return total;
    }

    public int getTotalAmountOfAllProgrammers() {
        int total = 0;
        for(Programmers programmer : Team.Programmers.values()){
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
