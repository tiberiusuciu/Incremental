package com.example.ergo.incremental.model.utils;

import com.example.ergo.incremental.model.Team;

import java.util.HashMap;

/**
 * Cette classe contien les statistiques de chaque programmeurs
 * CPS means Codes Per Second
 **/

public interface ProgrammersStats {

    // Performance de chaque fermier selon l'ordre de Team.ProgrammersPerformance
    final int[] cps = new int[]{ 12, 2, 20, 10, 20, 4, 6, 4, 3, 3, 12, 2, 4, 6, 5, 5, 7, 1, 10, 5};

    final String PERFORMANCE_UNIT = "codes per second";

    final String TIBERIU_NAME = "TIBERIU";
    final String DAVID_NAME = "DAVID";
    final String MICHAEL_NAME = "MICHAEL";
    final String JONATHAN_NAME = "JONATHAN";
    final String JIMMY_NAME = "JIMMY";
    final String MIECHKO_NAME = "MIECHKO";
    final String JEAN_DANIEL_NAME = "JEAN DANIEL";
    final String JESS_NAME = "JESS";
    final String XAVIER_NAME = "XAVIER";
    final String SEB_NAME = "SEB";
    final String SAMUEL_NAME = "SAMUEL";
    final String JEB_NAME = "JEB";
    final String NICOLAS_NAME = "NICOLAS";
    final String SOARES_NAME = "SOARES";
    final String VINCENT_NAME = "VINCENT";
    final String GUILLAUME_NAME = "GUILLAUME";
    final String ADAM_NAME = "ADAM";
    final String KEVIN_NAME = "KEVIN";
    final String GREG_NAME = "GREG";
    final String HERVE_NAME = "HERVE";
}
