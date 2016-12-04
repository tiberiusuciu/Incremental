package com.example.ergo.incremental.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ergo.incremental.R;
import com.example.ergo.incremental.threads.RandomEventThread;

/**
 * Created by ergo on 03/12/16.
 */

public class EventFragment extends Fragment {

    public static TextView eventName;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.event_fragment, container, false);
        eventName = (TextView) v.findViewById(R.id.eventName);
        eventName.setText(RandomEventThread.getEventName());
        return v;
    }
}
