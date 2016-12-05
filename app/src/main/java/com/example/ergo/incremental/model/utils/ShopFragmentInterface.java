package com.example.ergo.incremental.model.utils;

/**
 * Ici repose une classe pour réduire la complexité de la class ShopFragment
 */

public interface ShopFragmentInterface {
    //TODO: Remove these string calls here and add them in the string.xml of values
    String[] farmers = {
            FarmersStats.ADAM_NAME,
            FarmersStats.DAVID_NAME,
            FarmersStats.GREG_NAME,
            FarmersStats.GUILLAUME_NAME,
            FarmersStats.HERVE_NAME,
            FarmersStats.JEAN_DANIEL_NAME,
            FarmersStats.JEB_NAME,
            FarmersStats.JESS_NAME,
            FarmersStats.JIMMY_NAME,
            FarmersStats.JONATHAN_NAME,
            FarmersStats.KEVIN_NAME,
            FarmersStats.MICHAEL_NAME,
            FarmersStats.MIECHKO_NAME,
            FarmersStats.NICOLAS_NAME,
            FarmersStats.SAMUEL_NAME,
            FarmersStats.SEB_NAME,
            FarmersStats.SOARES_NAME,
            FarmersStats.TIBERIU_NAME,
            FarmersStats.VINCENT_NAME,
            FarmersStats.XAVIER_NAME
    };

    String[] farmerCurrencyTypes = {
            CurrencyNames.LINUX_NOM,
            CurrencyNames.ANIME_NOM,
            CurrencyNames.SILENCE_NOM,
            CurrencyNames.NOURRITURE_NOM,
            CurrencyNames.KIRIKOU_NOM,
            CurrencyNames.DND_NOM,
            CurrencyNames.PARTY_NOM,
            CurrencyNames.PIANO_NOM,
            CurrencyNames.BLINK_NOM,
            CurrencyNames.MOTIVATION_NOM,
            CurrencyNames.PRINCIPE_NOM,
            CurrencyNames.SOMMEIL_NOM,
            CurrencyNames.MAGIC_NOM,
            CurrencyNames.COUSIN_NOM,
            CurrencyNames.BACKFLIP_NOM,
            CurrencyNames.DARKSOULS_NOM,
            CurrencyNames.FRERE_JUMEAU_NOM,
            CurrencyNames.COIFFURE_NOM,
            CurrencyNames.CAFFEINN_NOM,
            CurrencyNames.ABSENCE_NOM
    };

    //TODO: Remove these string calls here and add them in the string.xml of values
    String[] farmerPrice = {
            FarmersStats.ADAM_COST + " " + FarmersStats.ADAM_CURRENCY,
            FarmersStats.DAVID_COST + " " + FarmersStats.DAVID_CURRENCY,
            FarmersStats.GREG_COST + " " + FarmersStats.GREG_CURRENCY,
            FarmersStats.GUILLAUME_COST + " " + FarmersStats.GUILLAUME_CURRENCY,
            FarmersStats.HERVE_COST + " " + FarmersStats.HERVE_CURRENCY,
            FarmersStats.JEAN_DANIEL_COST + " " + FarmersStats.JEAN_DANIEL_CURRENCY,
            FarmersStats.JEB_COST + " " + FarmersStats.JEB_CURRENCY,
            FarmersStats.JESS_COST + " " + FarmersStats.JESS_CURRENCY,
            FarmersStats.JIMMY_COST + " " + FarmersStats.JIMMY_CURRENCY,
            FarmersStats.JONATHAN_COST + " " + FarmersStats.JONATHAN_CURRENCY,
            FarmersStats.KEVIN_COST + " " + FarmersStats.KEVIN_CURRENCY,
            FarmersStats.MICHAEL_COST + " " + FarmersStats.MICHAEL_CURRENCY,
            FarmersStats.MIECHKO_COST + " " + FarmersStats.MIECHKO_CURRENCY,
            FarmersStats.NICOLAS_COST + " " + FarmersStats.NICOLAS_CURRENCY,
            FarmersStats.SAMUEL_COST + " " + FarmersStats.SAMUEL_CURRENCY,
            FarmersStats.SEB_COST + " " + FarmersStats.SEB_CURRENCY,
            FarmersStats.SOARES_COST + " " + FarmersStats.SOARES_CURRENCY,
            FarmersStats.TIBERIU_COST + " " + FarmersStats.TIBERIU_CURRENCY,
            FarmersStats.VINCENT_COST + " " + FarmersStats.VINCENT_CURRENCY,
            FarmersStats.XAVIER_COST + " " + FarmersStats.XAVIER_CURRENCY
    };

    //TODO: Remove these string calls here and add them in the string.xml of values
    String[] farmerPerformance = {
            FarmersStats.ADAM_CPS + " " + FarmersStats.PERFORMANCE_UNIT,
            FarmersStats.DAVID_CPS + " " + FarmersStats.PERFORMANCE_UNIT,
            FarmersStats.GREG_CPS + " " + FarmersStats.PERFORMANCE_UNIT,
            FarmersStats.GUILLAUME_CPS + " " + FarmersStats.PERFORMANCE_UNIT,
            FarmersStats.HERVE_CPS + " " + FarmersStats.PERFORMANCE_UNIT,
            FarmersStats.JEAN_DANIEL_CPS + " " + FarmersStats.PERFORMANCE_UNIT,
            FarmersStats.JEB_CPS + " " + FarmersStats.PERFORMANCE_UNIT,
            FarmersStats.JESS_CPS + " " + FarmersStats.PERFORMANCE_UNIT,
            FarmersStats.JIMMY_CPS + " " + FarmersStats.PERFORMANCE_UNIT,
            FarmersStats.JONATHAN_CPS + " " + FarmersStats.PERFORMANCE_UNIT,
            FarmersStats.KEVIN_CPS + " " + FarmersStats.PERFORMANCE_UNIT,
            FarmersStats.MICHAEL_CPS + " " + FarmersStats.PERFORMANCE_UNIT,
            FarmersStats.MIECHKO_CPS + " " + FarmersStats.PERFORMANCE_UNIT,
            FarmersStats.NICOLAS_CPS + " " + FarmersStats.PERFORMANCE_UNIT,
            FarmersStats.SAMUEL_CPS + " " + FarmersStats.PERFORMANCE_UNIT,
            FarmersStats.SEB_CPS + " " + FarmersStats.PERFORMANCE_UNIT,
            FarmersStats.SOARES_CPS + " " + FarmersStats.PERFORMANCE_UNIT,
            FarmersStats.TIBERIU_CPS + " " + FarmersStats.PERFORMANCE_UNIT,
            FarmersStats.VINCENT_CPS + " " + FarmersStats.PERFORMANCE_UNIT,
            FarmersStats.XAVIER_CPS + " " + FarmersStats.PERFORMANCE_UNIT
    };

    //TODO: Find images?
    Integer[] images = {
            1,
            2,
            3,
            4,
            5,
            6,
            7,
            8,
            9,
            10,
            11,
            12,
            13,
            14,
            15,
            16,
            17,
            18,
            19,
            20
    };
}
