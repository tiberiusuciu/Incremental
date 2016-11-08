package com.example.ergo.incremental.core_mechanics;

import com.example.ergo.incremental.utils.GameValues;

/**
 * Ceci est la class qui gère les niveaux ainsi que l'état de la partie (gagné, perdue)
 */

// Todo: make this class singleton as well
public class Game {

    static int availableTime = GameValues.TEMPS_PAR_NIVEAU;
    static int currentLevel = GameValues.STARTING_LEVEL;

    // FIXME: Duplicate code execution, is there a cleaner way to do this?
    static double codeToMake = Math.pow(GameValues.CODE_A_CREER_DE_BASE, currentLevel);

    public void calculateCodeToMake(){
        codeToMake = Math.pow(GameValues.CODE_A_CREER_DE_BASE, currentLevel);
    }

    public void levelUp() {
        if(currentLevel < GameValues.MAX_NIVEAU){
            currentLevel++;
            calculateCodeToMake();
        }
        else {
            gameOver();
        }
    }

    public void gameOver(){

    }
}
