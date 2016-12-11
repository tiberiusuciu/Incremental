package com.example.ergo.incremental.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.ergo.incremental.R;
import com.example.ergo.incremental.model.core_mechanics.Game;
import com.example.ergo.incremental.model.threads.RandomEventThread;
import com.example.ergo.incremental.model.utils.GameValues;

/**
 * Ceci est le fragment qui s'occupe pour l'affichage du temps courant, le code crée, le CPS, le niveau courant, la description du niveau
 */

public class StatsFragment extends Fragment {
    private static ProgressBar timeBar;
    private static ProgressBar codeBar;
    private static int codeProgress;
    private static int timeProgress;
    private static TextView timeText;
    private static TextView codeText;
    private static TextView codesPerSecond;
    private static TextView currentLevel;
    private static TextView levelDescription;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.stats_fragment, container, false);
        timeBar = (ProgressBar) v.findViewById(R.id.timeBar);
        timeBar.setMax(GameValues.TEMPS_PAR_NIVEAU);
        timeBar.setProgress(timeProgress);

        codeBar = (ProgressBar) v.findViewById(R.id.codeBar);
        codeBar.setMax((int)Game.codeToMake);
        codeBar.setProgress(codeProgress);

        timeText = (TextView) v.findViewById(R.id.timeText);
        codeText = (TextView) v.findViewById(R.id.codeText);

        codesPerSecond = (TextView) v.findViewById(R.id.cps);
        codesPerSecond.setText((int)(MainActivity.getUser().getCodesPerSecond() * RandomEventThread.getNewCPS()) + "");
        currentLevel = (TextView) v.findViewById(R.id.lvl);
        currentLevel.setText(Game.currentLevel + "");

        levelDescription = (TextView) v.findViewById(R.id.levelDescription);
        levelDescription.setText(GameValues.classNames[Game.currentLevel - 1]);

        return v;
    }

    public static ProgressBar getTimeBar() {
        return timeBar;
    }

    public static void setTimeBar(ProgressBar timeBar) {
        StatsFragment.timeBar = timeBar;
    }

    public static ProgressBar getCodeBar() {
        return codeBar;
    }

    public static void setCodeBar(ProgressBar codeBar) {
        StatsFragment.codeBar = codeBar;
    }

    public static int getCodeProgress() {
        return codeProgress;
    }

    public static void setCodeProgress(int codeProgress) {
        StatsFragment.codeProgress = codeProgress;
    }

    public static int getTimeProgress() {
        return timeProgress;
    }

    public static void setTimeProgress(int timeProgress) {
        StatsFragment.timeProgress = timeProgress;
    }

    public static TextView getTimeText() {
        return timeText;
    }

    public static void setTimeText(TextView timeText) {
        StatsFragment.timeText = timeText;
    }

    public static TextView getCodeText() {
        return codeText;
    }

    public static void setCodeText(TextView codeText) {
        StatsFragment.codeText = codeText;
    }

    public static TextView getCodesPerSecond() {
        return codesPerSecond;
    }

    public static void setCodesPerSecond(TextView codesPerSecond) {
        StatsFragment.codesPerSecond = codesPerSecond;
    }

    public static TextView getCurrentLevel() {
        return currentLevel;
    }

    public static void setCurrentLevel(TextView currentLevel) {
        StatsFragment.currentLevel = currentLevel;
    }

    public static TextView getLevelDescription() {
        return levelDescription;
    }

    public static void setLevelDescription(TextView levelDescription) {
        StatsFragment.levelDescription = levelDescription;
    }
}
