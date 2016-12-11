package com.example.ergo.incremental.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ergo.incremental.R;
import com.example.ergo.incremental.model.threads.RandomEventThread;

/**
 * Ceci est le fragment qui s'occupe à afficher la description de l'événement
 */

public class EventFragment extends Fragment {

    private static TextView eventName;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.event_fragment, container, false);
        eventName = (TextView) v.findViewById(R.id.eventName);
        eventName.setText(RandomEventThread.getEventName());
        return v;
    }

    public static TextView getEventName() {
        return eventName;
    }

    public static void setEventName(TextView eventName) {
        EventFragment.eventName = eventName;
    }
}
