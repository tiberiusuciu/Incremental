package com.example.ergo.incremental.model.utils;

import com.example.ergo.incremental.model.Team;

import java.util.HashMap;

/**
 * This class contains the stats for each Farmer
 * CPS means Codes Per Second
 *
 * Les Farmers peuvent être acheté avec des objets provenant
 * de la classe mère nommé Currency
 *
 * Les variables avec COST indiquent le nombre d`objets
 * necessaire pour acheter un des Farmer
 **/

public interface FarmersStats {

    final int[] cps = new int[]{ 12, 2, 20, 10, 20, 4, 6, 4, 3, 3, 12, 2, 4, 6, 5, 5, 7, 1, 10, 5};

    final String PERFORMANCE_UNIT = "codes per second";

    final String TIBERIU_CURRENCY = "COIFFURE(S)";
    final String TIBERIU_NAME = "TIBERIU";
    final int TIBERIU_CPS = 1;
    final int TIBERIU_COST = 2;

    final String DAVID_CURRENCY = "ANIME(S)";
    final String DAVID_NAME = "DAVID";
    final int DAVID_CPS = 2;
    final int DAVID_COST = 2;

    final String MICHAEL_CURRENCY = "SOMMEIL(S)";
    final String MICHAEL_NAME = "MICHAEL";
    final int MICHAEL_CPS = 2;
    final int MICHAEL_COST = 2;

    final String JONATHAN_CURRENCY = "MOTIVATION(S)";
    final String JONATHAN_NAME = "JONATHAN";
    final int JONATHAN_CPS = 3;
    final int JONATHAN_COST = 2;

    final String JIMMY_CURRENCY = "BLINK(S)";
    final String JIMMY_NAME = "JIMMY";
    final int JIMMY_CPS = 3;
    final int JIMMY_COST = 2;

    final String MIECHKO_CURRENCY = "MAGIC(S)";
    final String MIECHKO_NAME = "MIECHKO";
    final int MIECHKO_CPS = 4;
    final int MIECHKO_COST = 2;

    final String JEAN_DANIEL_CURRENCY = "DND(S)";
    final String JEAN_DANIEL_NAME = "JEAN DANIEL";
    final int JEAN_DANIEL_CPS = 4;
    final int JEAN_DANIEL_COST = 2;

    final String JESS_CURRENCY = "PIANO(S)";
    final String JESS_NAME = "JESS";
    final int JESS_CPS = 4;
    final int JESS_COST = 2;

    final String XAVIER_CURRENCY = "ABSENCE(S)";
    final String XAVIER_NAME = "XAVIER";
    final int XAVIER_CPS = 5;
    final int XAVIER_COST = 2;

    final String SEB_CURRENCY = "DARK SOULS(S)";
    final String SEB_NAME = "SEB";
    final int SEB_CPS = 5;
    final int SEB_COST = 2;

    final String SAMUEL_CURRENCY = "BACKFLIP(S)";
    final String SAMUEL_NAME = "SAMUEL";
    final int SAMUEL_CPS = 5;
    final int SAMUEL_COST = 2;

    final String JEB_CURRENCY = "PARTY(S)";
    final String JEB_NAME = "JEB";
    final int JEB_CPS = 6;
    final int JEB_COST = 2;

    final String NICOLAS_CURRENCY = "COUSIN(S)";
    final String NICOLAS_NAME = "NICOLAS";
    final int NICOLAS_CPS = 6;
    final int NICOLAS_COST = 2;

    final String SOARES_CURRENCY = "FRERE(S) JUMEAU(X)";
    final String SOARES_NAME = "SOARES";
    final int SOARES_CPS = 7;
    final int SOARES_COST = 2;

    final String VINCENT_CURRENCY = "CAFFEINN(S)";
    final String VINCENT_NAME = "VINCENT";
    final int VINCENT_CPS = 10;
    final int VINCENT_COST = 2;

    final String GUILLAUME_CURRENCY = "NOURRITURE(S)";
    final String GUILLAUME_NAME = "GUILLAUME";
    final int GUILLAUME_CPS = 10;
    final int GUILLAUME_COST = 2;

    final String ADAM_CURRENCY = "LINUX(S)";
    final String ADAM_NAME = "ADAM";
    final int ADAM_CPS = 12;
    final int ADAM_COST = 2;

    final String KEVIN_CURRENCY = "PRINCIPE(S)";
    final String KEVIN_NAME = "KEVIN";
    final int KEVIN_CPS = 12;
    final int KEVIN_COST = 2;

    final String GREG_CURRENCY = "SILENCE(S)";
    final String GREG_NAME = "GREG";
    final int GREG_CPS = 20;
    final int GREG_COST = 2;

    final String HERVE_CURRENCY = "KIRIKOU(S)";
    final String HERVE_NAME = "HERVE";
    final int HERVE_CPS = 20;
    final int HERVE_COST = 2;
}
