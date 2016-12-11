package com.example.ergo.incremental.model.utils;

import com.example.ergo.incremental.R;
import com.example.ergo.incremental.controller.MainActivity;

/**
 * Ici repose les valeurs par defauts du jeu
 */

public interface GameValues {
    final int TEMPS_PAR_NIVEAU = 180;
    final int STARTING_LEVEL = 1;
    final int MAX_NIVEAU = 24;
    final int MONNAIE_A_CHAQUE_X_SECONDES = 5;
    final double CODE_A_CREER_DE_BASE = 1.8;
    final int PRIX_DE_BASE = 2;
    final int EVENT_DURATION = 60;
    final String[] currencyNames = {
        "Absence",
        "Anime",
        "Backflip",
        "Blink",
        "CaffeInn",
        "Coiffure",
        "Cousin",
        "DarkSouls",
        "Dnd",
        "FrereJumeau",
        "Kirikou",
        "Linux",
        "Magic",
        "Motivation",
        "Nourriture",
        "Party",
        "Piano",
        "Principe",
        "Silence",
        "Sommeil"
    };

    // Ceci est ma collection d'événements rassemblé dans un array de String. Je ne fait qu'en chosir un aléatoirement
    final String[] eventNames = {
            MainActivity.getAppContext().getString(R.string.fin_session),
            MainActivity.getAppContext().getString(R.string.eclipse_install),
            MainActivity.getAppContext().getString(R.string.scrum),
            MainActivity.getAppContext().getString(R.string.new_pokemon),
            MainActivity.getAppContext().getString(R.string.wow_expansion),
            MainActivity.getAppContext().getString(R.string.boss_monster),
            MainActivity.getAppContext().getString(R.string.deux_mille_quarante_huite),
            MainActivity.getAppContext().getString(R.string.civilisation),
            MainActivity.getAppContext().getString(R.string.lan),
            MainActivity.getAppContext().getString(R.string.lunchbox),
            MainActivity.getAppContext().getString(R.string.bouteille_deau),
            MainActivity.getAppContext().getString(R.string.bug),
            MainActivity.getAppContext().getString(R.string.no_sleep),
            MainActivity.getAppContext().getString(R.string.stackoverflow),
            MainActivity.getAppContext().getString(R.string.guillaume_fait_tout),
            MainActivity.getAppContext().getString(R.string.reda_fache),
            MainActivity.getAppContext().getString(R.string.benoit_oublie_lunette),
            MainActivity.getAppContext().getString(R.string.mac_user),
            MainActivity.getAppContext().getString(R.string.easy_tp),
            MainActivity.getAppContext().getString(R.string.chris_loves_tp),
            MainActivity.getAppContext().getString(R.string.no_more_magic),
            MainActivity.getAppContext().getString(R.string.john_motivation),
            MainActivity.getAppContext().getString(R.string.hackerman),
            MainActivity.getAppContext().getString(R.string.lucid_dreams),
            MainActivity.getAppContext().getString(R.string.teamplay),
            MainActivity.getAppContext().getString(R.string.decompile),
            MainActivity.getAppContext().getString(R.string.kevin_loves_eclipse),
            MainActivity.getAppContext().getString(R.string.shinobi_training),
            MainActivity.getAppContext().getString(R.string.singing_duet),
            MainActivity.getAppContext().getString(R.string.questing_time),
            MainActivity.getAppContext().getString(R.string.chris_never_reads),
            MainActivity.getAppContext().getString(R.string.chris_is_mad),
            MainActivity.getAppContext().getString(R.string.xavier_is_late),
            MainActivity.getAppContext().getString(R.string.spanish_inquisition),
            MainActivity.getAppContext().getString(R.string.larp_weekend),
            MainActivity.getAppContext().getString(R.string.abstract_class),
            MainActivity.getAppContext().getString(R.string.singleton_debate),
            MainActivity.getAppContext().getString(R.string.idk_what_to_chose),
            MainActivity.getAppContext().getString(R.string.free_will),
            MainActivity.getAppContext().getString(R.string.avoid_work),
            MainActivity.getAppContext().getString(R.string.no_more_gym),
            MainActivity.getAppContext().getString(R.string.pepe)
    };

    // Ceci est le pourcentage de changement au CPS
    final double[] eventEffects = {
            2,
            0.5,
            1.5,
            0.8,
            0.8,
            0.7,
            0.7,
            0.6,
            0.6,
            0.9,
            0.9,
            1.2,
            1.8,
            2.5,
            2,
            2.5,
            2.5,
            2.7,
            3.25,
            3,
            3.5,
            1.5,
            3,
            2.5,
            1,
            3.5,
            0.2,
            0.3,
            1.05,
            0.2,
            0.5,
            0.99,
            0.8,
            0.1,
            3,
            0.83,
            0.9,
            0.45,
            0.3,
            2.2,
            3,
            1.5
    };
    // Ce sont une des seuls valeurs que je n'ai pas convertis en anglais et français, car c'est des noms spécifiques
    // Ceci sont les descriptions pour chaque niveau, c'est la raison pourquoi il y a exactement 24 niveau dans mon jeu
    final String[] classNames = {
            MainActivity.getAppContext().getString(R.string.maths1),
            MainActivity.getAppContext().getString(R.string.prog1),
            MainActivity.getAppContext().getString(R.string.computers),
            MainActivity.getAppContext().getString(R.string.internet),
            MainActivity.getAppContext().getString(R.string.prog2),
            MainActivity.getAppContext().getString(R.string.os),
            MainActivity.getAppContext().getString(R.string.web1),
            MainActivity.getAppContext().getString(R.string.prog3),
            MainActivity.getAppContext().getString(R.string.network),
            MainActivity.getAppContext().getString(R.string.web2),
            MainActivity.getAppContext().getString(R.string.uml), 
            MainActivity.getAppContext().getString(R.string.maths2), 
            MainActivity.getAppContext().getString(R.string.comm),
            MainActivity.getAppContext().getString(R.string.prog4),
            MainActivity.getAppContext().getString(R.string.security),
            MainActivity.getAppContext().getString(R.string.db),
            MainActivity.getAppContext().getString(R.string.enterprise),
            MainActivity.getAppContext().getString(R.string.prog_ui),
            MainActivity.getAppContext().getString(R.string.qa),
            MainActivity.getAppContext().getString(R.string.multi_tier),
            MainActivity.getAppContext().getString(R.string.oibd),
            MainActivity.getAppContext().getString(R.string.solutions),
            MainActivity.getAppContext().getString(R.string.project),
            MainActivity.getAppContext().getString(R.string.seminar)
    };
}
