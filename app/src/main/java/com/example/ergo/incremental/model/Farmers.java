package com.example.ergo.incremental.model;

import com.example.ergo.incremental.model.utils.FarmersStats;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ergo on 10/12/16.
 */

public class Farmers {
    private static Map<Team.Programmers, Integer> programmerPerformance = initPerformanceMap();

    private static Map<Team.Programmers, Integer> initPerformanceMap() {
        HashMap<Team.Programmers, Integer> map = new HashMap<>();
        int index = 0;
        for(Team.Programmers programmers : Team.Programmers.values()){
            map.put(programmers, FarmersStats.cps[index]);
            index++;
        }
        return map;
    }

    public int getPerformanceOfProgrammer(Team.Programmers programmer) {
        return programmerPerformance.get(programmer);
    }
}
