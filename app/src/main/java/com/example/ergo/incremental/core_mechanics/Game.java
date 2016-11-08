package com.example.ergo.incremental.core_mechanics;

import com.example.ergo.incremental.utils.GameValues;

/**
 * Ceci est la class qui gère les niveaux ainsi que l'état de la partie (gagné, perdue)
 */

// Todo: make this class singleton as well
public class Game {

    public static int availableTime = GameValues.TEMPS_PAR_NIVEAU;
    public static int currentLevel = GameValues.STARTING_LEVEL;

    // FIXME: Duplicate code execution, is there a cleaner way to do this?
    public static double codeToMake = Math.pow(GameValues.CODE_A_CREER_DE_BASE, currentLevel);

    public static void calculateCodeToMake(){
        codeToMake = Math.pow(GameValues.CODE_A_CREER_DE_BASE, currentLevel);
    }

    public static  void levelUp() {
        if(currentLevel < GameValues.MAX_NIVEAU){
            currentLevel++;
            calculateCodeToMake();
        }
        else {
            gameOver();
        }
    }

    public static void gameOver(){

    }

    public static String formatTime(int seconds) {
        int formatSeconds = seconds%60;
        seconds -= formatSeconds;
        int formatMinutes = seconds/60;
        return formatMinutes + "m" + formatSeconds + "s";
    }
}
