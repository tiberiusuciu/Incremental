package com.example.ergo.incremental.view;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ergo.incremental.R;
import com.example.ergo.incremental.controller.core_mechanics.Game;

/**
 * Ceci est le fragment du bouton pour créer du code
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
                    StatsFragment.codeBar.setProgress(StatsFragment.codeBar.getProgress() + 1);
                    StatsFragment.codeText.setText(getString(R.string.remaining_code) + " " + (Game.codeToMake - StatsFragment.codeBar.getProgress()));
                    if(StatsFragment.codeBar.getProgress() == Game.codeToMake){
                        Game.levelUp();
                        StatsFragment.codeBar.setProgress(0);
                        StatsFragment.codeBar.setMax(Game.codeToMake);
                        StatsFragment.codeText.setText(getString(R.string.beggining_code));
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
