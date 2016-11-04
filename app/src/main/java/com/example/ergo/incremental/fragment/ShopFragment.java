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
        //TODO: Remove these string calls here and add them in the string.xml of values
        //TODO: Place this array somewhere else in the utils?
        String[] farmerPrice = {
                FarmersStats.ADAM_COST + " " + FarmersStats.ADAM_CURRENCY,
                FarmersStats.DAVIDE_COST + " " + FarmersStats.DAVIDE_CURRENCY,
                FarmersStats.GREG_COST + " " + FarmersStats.GREG_CURRENCY,
                FarmersStats.GUILLAUME_COST + " " + FarmersStats.GUILLAUME_CURRENCY,
                FarmersStats.HERVE_COST + " " + FarmersStats.HERVE_CURRENCY,
                FarmersStats.JEAN_DANIEL_COST + " " + FarmersStats.JEAN_DANIEL_CURRENCY,
                FarmersStats.JEB_COST + " " + FarmersStats.JEB_CURRENCY,
                FarmersStats.JESS_COST + " " + FarmersStats.JESS_CURRENCY,
                FarmersStats.JIMMY_COST + " " + FarmersStats.JIMMY_CURRENCY,
                FarmersStats.JONATHAN_COST + " " + FarmersStats.JONATHAN_CURRENCY,
                FarmersStats.KEVIN_COST + " " + FarmersStats.KEVIN_CURRENCY,
                FarmersStats.MICHEAL_COST + " " + FarmersStats.MICHEAL_CURRENCY,
                FarmersStats.MIECHKO_COST + " " + FarmersStats.MIECHKO_CURRENCY,
                FarmersStats.NICOLAS_COST + " " + FarmersStats.NICOLAS_CURRENCY,
                FarmersStats.SAMUEL_COST + " " + FarmersStats.SAMUEL_CURRENCY,
                FarmersStats.SEB_COST + " " + FarmersStats.SEB_CURRENCY,
                FarmersStats.SOARES_COST + " " + FarmersStats.SOARES_CURRENCY,
                FarmersStats.TIBERIU_COST + " " + FarmersStats.TIBERIU_CURRENCY,
                FarmersStats.VINCENT_COST + " " + FarmersStats.VINCENT_CURRENCY,
                FarmersStats.XAVIER_COST + " " + FarmersStats.XAVIER_CURRENCY
        };
        //TODO: Remove these string calls here and add them in the string.xml of values
        //TODO: Place this array somewhere else in the utils?
        String[] farmerPerformance = {
                FarmersStats.ADAM_CPS + " " + FarmersStats.PERFORMANCE_UNIT,
                FarmersStats.DAVIDE_CPS + " " + FarmersStats.PERFORMANCE_UNIT,
                FarmersStats.GREG_CPS + " " + FarmersStats.PERFORMANCE_UNIT,
                FarmersStats.GUILLAUME_CPS + " " + FarmersStats.PERFORMANCE_UNIT,
                FarmersStats.HERVE_CPS + " " + FarmersStats.PERFORMANCE_UNIT,
                FarmersStats.JEAN_DANIEL_CPS + " " + FarmersStats.PERFORMANCE_UNIT,
                FarmersStats.JEB_CPS + " " + FarmersStats.PERFORMANCE_UNIT,
                FarmersStats.JESS_CPS + " " + FarmersStats.PERFORMANCE_UNIT,
                FarmersStats.JIMMY_CPS + " " + FarmersStats.PERFORMANCE_UNIT,
                FarmersStats.JONATHAN_CPS + " " + FarmersStats.PERFORMANCE_UNIT,
                FarmersStats.KEVIN_CPS + " " + FarmersStats.PERFORMANCE_UNIT,
                FarmersStats.MICHEAL_CPS + " " + FarmersStats.PERFORMANCE_UNIT,
                FarmersStats.MIECHKO_CPS + " " + FarmersStats.PERFORMANCE_UNIT,
                FarmersStats.NICOLAS_CPS + " " + FarmersStats.PERFORMANCE_UNIT,
                FarmersStats.SAMUEL_CPS + " " + FarmersStats.PERFORMANCE_UNIT,
                FarmersStats.SEB_CPS + " " + FarmersStats.PERFORMANCE_UNIT,
                FarmersStats.SOARES_CPS + " " + FarmersStats.PERFORMANCE_UNIT,
                FarmersStats.TIBERIU_CPS + " " + FarmersStats.PERFORMANCE_UNIT,
                FarmersStats.VINCENT_CPS + " " + FarmersStats.PERFORMANCE_UNIT,
                FarmersStats.XAVIER_CPS + " " + FarmersStats.PERFORMANCE_UNIT
        };
        //TODO: Find images?
        //TODO: Place this array somewhere else in the utils?
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

        CustomList adapter = new CustomList(getActivity(), farmers, farmerPrice, farmerPerformance, images);
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
