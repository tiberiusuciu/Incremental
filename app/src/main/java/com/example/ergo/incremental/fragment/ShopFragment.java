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
import android.widget.TextView;
import android.widget.Toast;

import com.example.ergo.incremental.CustomList;
import com.example.ergo.incremental.MainActivity;
import com.example.ergo.incremental.R;
import com.example.ergo.incremental.currency.Currency;
import com.example.ergo.incremental.farmer.Farmer;
import com.example.ergo.incremental.utils.FarmersStats;
import com.example.ergo.incremental.utils.GameValues;
import com.example.ergo.incremental.utils.ShopFragmentInterface;


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
        if(MainActivity.user.findSpecificAmountMonnaie(farmerPrice[position], 2)) {
            MainActivity.user.removeSpecificAmountMonnaie(farmerPrice[position], 2);
            Class<?> myClass = null;
            Farmer farmer = null;
            try {
                String farmerClassName = ShopFragmentInterface.farmers[position];
                farmerClassName = farmerClassName.toLowerCase();
                farmerClassName = farmerClassName.substring(0, 1).toUpperCase() + farmerClassName.substring(1);
                farmerClassName += "Farmer";
                myClass = Class.forName("com.example.ergo.incremental.farmer." + farmerClassName );
                farmer = (Farmer) myClass.newInstance();
                MainActivity.user.addFarmer(farmer);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (java.lang.InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        else {
            Toast.makeText(getContext(), "You do not have enough to buy a " + farmers[position], Toast.LENGTH_SHORT).show();
        }

    }
}
