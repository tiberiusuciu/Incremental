package com.example.ergo.incremental.model.utils;

/**
 * Ici repose les valeurs par defauts du jeu
 */

public interface GameValues {
    final int TEMPS_PAR_NIVEAU = 180;
    final int STARTING_LEVEL = 1;
    final int MAX_NIVEAU = 24;
    final int MONNAIE_A_CHAQUE_X_SECONDES = 5;
    final double CODE_A_CREER_DE_BASE = 2;
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
    final String[] eventNames = {
            "La fin de session approche, tous les fermiers travaillent extra, productivité augmentée!",
            "Les fermiers doivent ré-installer Eclipse, productivité ralenti!",
            "Les fermiers font le SCRUM, productivité augmentée!"
    };

    // Ceci est le pourcentage de changement au CPS
    final double[] eventEffects = {
            2,
            0.5,
            1.5
    };
}
