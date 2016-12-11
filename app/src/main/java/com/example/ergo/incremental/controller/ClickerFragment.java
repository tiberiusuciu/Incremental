package com.example.ergo.incremental.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ergo.incremental.R;
import com.example.ergo.incremental.model.core_mechanics.Game;

/**
 * Ceci est le fragment du bouton pour faire du code
 */


// TODO remove STATSFRAGMENT and put it in a variable, it will be more cleaner
public class ClickerFragment extends Fragment {
    private static Button button;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.clicker_fragment, container, false);
        button = (Button) v.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    StatsFragment.getCodeBar().setProgress(StatsFragment.getCodeBar().getProgress() + 1);
                    StatsFragment.getCodeText().setText(getString(R.string.remaining_code) + " " + (Game.codeToMake - StatsFragment.getCodeBar().getProgress()));
                    if(StatsFragment.getCodeBar().getProgress() >= Game.codeToMake){
                        Game.levelUp();
                        StatsFragment.getCodeBar().setProgress(0);
                        StatsFragment.getCodeBar().setMax(Game.codeToMake);
                        StatsFragment.getCodeText().setText(getString(R.string.beggining_code));
                    }
                }
            }
        );
        return v;
    }

    public static Button getButton() {
        return button;
    }

    public static void setButton(Button button) {
        ClickerFragment.button = button;
    }
}
