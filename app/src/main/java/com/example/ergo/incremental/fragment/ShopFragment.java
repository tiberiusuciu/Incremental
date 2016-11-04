package com.example.ergo.incremental.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ergo.incremental.CustomList;
import com.example.ergo.incremental.R;
import com.example.ergo.incremental.farmer.Farmer;
import com.example.ergo.incremental.utils.FarmersStats;


public class ShopFragment extends Fragment {

    ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shop_fragment, container, false);
        String[] farmers = {
                FarmersStats.ADAM_NAME,
                FarmersStats.DAVIDE_NAME,
                FarmersStats.GREG_NAME,
                FarmersStats.GUILLAUME_NAME,
                FarmersStats.HERVE_NAME,
                FarmersStats.JEAN_DANIEL_NAME,
                FarmersStats.JEB_NAME,
                FarmersStats.JESS_NAME,
                FarmersStats.JIMMY_NAME,
                FarmersStats.JONATHAN_NAME,
                FarmersStats.KEVIN_NAME,
                FarmersStats.MICHEAL_NAME,
                FarmersStats.MIECHKO_NAME,
                FarmersStats.NICOLAS_NAME,
                FarmersStats.SAMUEL_NAME,
                FarmersStats.SEB_NAME,
                FarmersStats.SOARES_NAME,
                FarmersStats.TIBERIU_NAME,
                FarmersStats.VINCENT_NAME,
                FarmersStats.XAVIER_NAME
        };

        Integer[] images = {
                1,
                2,
                3,
                4,
                5,
                6,
                7,
                8,
                9,
                10,
                11,
                12,
                13,
                14,
                15,
                16,
                17,
                18,
                19,
                20
        };

        CustomList adapter = new CustomList(getActivity(), farmers, images);
        listView = (ListView) view.findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        itemClicked(view, i);
                    }
                }
        );
        return view;
    }

    public void itemClicked(View view, int position) {
        Toast.makeText(getContext(), "You Clicked at " + position, Toast.LENGTH_SHORT).show();
    }
}
