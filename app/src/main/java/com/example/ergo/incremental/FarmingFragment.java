package com.example.ergo.incremental;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Ceci est le fragment qui gère la page principale, elle affiche le bouton ainsi que les statistiques du jeu
 */

public class FarmingFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.farming_fragment, container, false);
    }
}
