package com.example.ergo.incremental.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ergo.incremental.R;

/**
 * Ceci est le fragment du bouton pour créer du code
 */

public class ClickerFragment extends Fragment {
    Button button;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.clicker_fragment, container, false);
        button = (Button) v.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    StatsFragment.progressBar.setSecondaryProgress(StatsFragment.progressBar.getSecondaryProgress() + 1);
                }
            }
        );
        return v;
    }
}
