package com.example.ergo.incremental.controller.core_mechanics;

import android.content.Intent;

import com.example.ergo.incremental.R;
import com.example.ergo.incremental.view.GameOver;
import com.example.ergo.incremental.view.MainActivity;
import com.example.ergo.incremental.view.ShopFragment;
import com.example.ergo.incremental.view.StatsFragment;
import com.example.ergo.incremental.controller.threads.EllapsedTimeThread;
import com.example.ergo.incremental.model.utils.GameValues;

/**
 * Ceci est la class qui gère les niveaux ainsi que l'état de la partie (gagné, perdue)
 */

// Todo: make this class singleton as well
public class Game {

    public static boolean isGameOver = false;
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
            renderUI();
        }
        else {
            gameOver();
        }
    }

    public static void downgrade() {
        if(currentLevel > 1) {
            currentLevel--;
            calculateCodeToMake();
            renderUI();
        }
    }

    private static void renderUI() {
        StatsFragment.timeBar.setProgress(0);
        StatsFragment.codeBar.setProgress(0);
        StatsFragment.codeBar.setMax(codeToMake);
        StatsFragment.currentLevel.setText(currentLevel + "");
        // Le -1 s'explique puisqu'on commence au niveau 1, mais on veut commencer a accéder à notre collection à partir de 0
        StatsFragment.levelDescription.setText(GameValues.classNames[currentLevel - 1]);
    }

    private static void gameOver(){
        isGameOver = true;
        Intent intent = new Intent(MainActivity.getAppContext(), GameOver.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        int ellapsedTime = EllapsedTimeThread.getEllapsedTime();
        int totalFarmers = MainActivity.user.getTravaileurs().size();
        intent.putExtra("ellapsedTime", ellapsedTime + "");
        intent.putExtra("totalFarmers", totalFarmers + "");
        MainActivity.getAppContext().startActivity(intent);

    }

    public static String formatTime(int seconds) {
        int formatSeconds = seconds%60;
        seconds -= formatSeconds;
        int formatMinutes = seconds/60;
        return formatMinutes + "m" + formatSeconds + "s";
    }
}
