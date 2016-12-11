package com.example.ergo.incremental.model;

import com.example.ergo.incremental.model.utils.ProgrammersStats;

import java.util.HashMap;
import java.util.Map;

/**
 * Ceci est une classe qui permet de relier le nom d'un programmeur avec sa performace attribués
 * Cette classe nous facilite l'accès ensuite au statistiques de chaque programmeurs
 */

public class ProgrammersPerformance {
    private static Map<Team.Programmers, Integer> programmerPerformance = initPerformanceMap();

    private static Map<Team.Programmers, Integer> initPerformanceMap() {
        HashMap<Team.Programmers, Integer> map = new HashMap<>();
        int index = 0;
        for(Team.Programmers programmers : Team.Programmers.values()){
            map.put(programmers, ProgrammersStats.cps[index]);
            index++;
        }
        return map;
    }

    public static int getPerformanceOfProgrammer(Team.Programmers programmer) {
        return programmerPerformance.get(programmer);
    }
}
