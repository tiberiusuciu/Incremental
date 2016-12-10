package com.example.ergo.incremental.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ergo.incremental.R;
import com.example.ergo.incremental.model.Team;
import com.example.ergo.incremental.model.Wallet;
import com.example.ergo.incremental.model.utils.GameValues;
import com.example.ergo.incremental.model.utils.ShopFragmentInterface;


public class ShopFragment extends Fragment {

    public static ListView listView;
    protected String[] farmers;
    protected String[] farmerPrice;
    protected String[] farmerPerformance;
    protected Integer[] images;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shop_fragment, container, false);
        farmers = ShopFragmentInterface.farmers;
        farmerPrice = ShopFragmentInterface.farmerCurrencyTypes;
        farmerPerformance = ShopFragmentInterface.farmerPerformance;
        images = ShopFragmentInterface.images;

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
        if(MainActivity.user.findSpecificAmountMonnaie(Wallet.Currency.values()[position], 2)) {
            MainActivity.user.removeSpecificAmountMonnaie(Wallet.Currency.values()[position], 2);
            MainActivity.user.addFarmer(Team.Programmers.values()[position]);
            // Mise à jour de mes listeViews
            ((BaseAdapter)listView.getAdapter()).notifyDataSetChanged();
            ((BaseAdapter)FarmersFragment.listViewofFarmers.getAdapter()).notifyDataSetChanged();
        }
        else {
            Toast.makeText(getContext(), getString(R.string.not_enough_money) + farmers[position], Toast.LENGTH_SHORT).show();
        }

    }
}
