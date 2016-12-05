package com.example.ergo.incremental;

import com.example.ergo.incremental.core_mechanics.Game;
import com.example.ergo.incremental.utils.GameValues;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 *  Ici repose les tests pour la class Game, je tests ce que je peux, cependant, il y a quelques méthodes qui
 *  accèdent aux widget de l'application
 */

public class GameTest {
    public int totalSeconds = 360;
    public String formatedTotalSeconds = "6m0s";

    public int level = 24;
    public int totalCodeToMake = (int)Math.pow(GameValues.CODE_A_CREER_DE_BASE, level);
    @Test
    public void formatting_time() throws Exception {
        assertEquals(Game.formatTime(totalSeconds), formatedTotalSeconds);
    }

    @Test
    public void calculate_code_to_make() throws Exception {
        Game.currentLevel = level;
        Game.calculateCodeToMake();
        assertEquals(Game.codeToMake, totalCodeToMake);
    }
}
