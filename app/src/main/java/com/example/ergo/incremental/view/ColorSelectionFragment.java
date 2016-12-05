package com.example.ergo.incremental.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ergo.incremental.R;

/**
 * Created by ergo on 04/12/16.
 */

public class ColorSelectionFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.color_selection_dialogue, container, false);
        return v;
    }
}
