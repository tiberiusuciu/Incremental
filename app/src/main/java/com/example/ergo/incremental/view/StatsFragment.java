package com.example.ergo.incremental.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.ergo.incremental.R;
import com.example.ergo.incremental.controller.core_mechanics.Game;
import com.example.ergo.incremental.controller.threads.RandomEventThread;
import com.example.ergo.incremental.model.utils.GameValues;

/**
 * Created by ergo on 03/11/16.
 */

public class StatsFragment extends Fragment {
    public static ProgressBar timeBar;
    public static ProgressBar codeBar;
    public static TextView timeText;
    public static TextView codeText;
    public static TextView codesPerSecond;
    public static TextView currentLevel;
    public static TextView levelDescription;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.stats_fragment, container, false);
        timeBar = (ProgressBar) v.findViewById(R.id.timeBar);
        timeBar.setMax(GameValues.TEMPS_PAR_NIVEAU);
        timeBar.setProgress(0);

        codeBar = (ProgressBar) v.findViewById(R.id.codeBar);
        codeBar.setMax((int)Game.codeToMake);
        codeBar.setProgress(0);

        timeText = (TextView) v.findViewById(R.id.timeText);
        codeText = (TextView) v.findViewById(R.id.codeText);

        codesPerSecond = (TextView) v.findViewById(R.id.cps);
        codesPerSecond.setText((int)(MainActivity.user.getCodesPerSecond() * RandomEventThread.getNewCPS()) + "");
        currentLevel = (TextView) v.findViewById(R.id.lvl);
        currentLevel.setText(Game.currentLevel + "");

        levelDescription = (TextView) v.findViewById(R.id.levelDescription);
        levelDescription.setText(GameValues.classNames[Game.currentLevel]);

        return v;
    }
}
