package com.example.ergo.incremental.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.ergo.incremental.R;

/**
 * Created by ergo on 03/11/16.
 */

public class StatsFragment extends Fragment {
    public static ProgressBar progressBar;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.stats_fragment, container, false);
        progressBar = (ProgressBar) v.findViewById(R.id.progressBar);
        progressBar.setMax(180);
        progressBar.setProgress(0);
        progressBar.setSecondaryProgress(0);
        return v;
    }
}
