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
import com.example.ergo.incremental.utils.ShopFragmentInterface;


public class ShopFragment extends Fragment {

    public static ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shop_fragment, container, false);
        String[] farmers = ShopFragmentInterface.farmers;
        String[] farmerPrice = ShopFragmentInterface.farmerCurrencyTypes;
        String[] farmerPerformance = ShopFragmentInterface.farmerPerformance;
        Integer[] images = ShopFragmentInterface.images;

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
