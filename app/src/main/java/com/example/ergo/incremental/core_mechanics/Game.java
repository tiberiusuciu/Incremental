package com.example.ergo.incremental.core_mechanics;

import com.example.ergo.incremental.R;
import com.example.ergo.incremental.fragment.StatsFragment;
import com.example.ergo.incremental.utils.GameValues;
import com.example.ergo.incremental.utils.ShopFragmentInterface;

/**
 * Ceci est la class qui gère les niveaux ainsi que l'état de la partie (gagné, perdue)
 */

// Todo: make this class singleton as well
public class Game {

    public static boolean isGameOver = false;
    public static int availableTime = GameValues.TEMPS_PAR_NIVEAU;
    public static int currentLevel = GameValues.STARTING_LEVEL;

    // FIXME: Duplicate code execution, is there a cleaner way to do this?
    public static int codeToMake = (int)Math.pow(GameValues.CODE_A_CREER_DE_BASE, currentLevel);

    public static void calculateCodeToMake(){
        codeToMake = (int)Math.pow(GameValues.CODE_A_CREER_DE_BASE, currentLevel);
    }

    public static void levelUp() {
        if(currentLevel < GameValues.MAX_NIVEAU){
            currentLevel++;
            calculateCodeToMake();
            StatsFragment.timeBar.setProgress(0);
            StatsFragment.currentLevel.setText(currentLevel + "");
        }
        else {
            gameOver();
        }
    }

    public static void gameOver(){
        isGameOver = true;
    }

    public static String formatTime(int seconds) {
        int formatSeconds = seconds%60;
        seconds -= formatSeconds;
        int formatMinutes = seconds/60;
        return formatMinutes + "m" + formatSeconds + "s";
    }
}
