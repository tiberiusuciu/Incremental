package com.example.ergo.incremental.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.ergo.incremental.R;
import com.example.ergo.incremental.model.utils.ShopFragmentInterface;

/**
 * Created by ergo on 03/11/16.
 */

public class FarmersFragment extends Fragment {

    public static ListView listViewofFarmers;
    protected String[] farmers;
    protected Integer[] images;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.farmers_fragment, container, false);

        farmers = ShopFragmentInterface.farmers;
        images = ShopFragmentInterface.images;

        CustomListObtainedFarmers adapter = new CustomListObtainedFarmers(getActivity(), farmers, images);
        listViewofFarmers = (ListView) view.findViewById(R.id.listviewObtainedFarmers);
        listViewofFarmers.setAdapter(adapter);

        return view;
    }
}
