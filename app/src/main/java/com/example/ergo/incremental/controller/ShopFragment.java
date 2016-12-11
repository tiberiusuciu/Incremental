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

/**
 * Fragment de magasin pour acheter mes programmeurs, l'usager devra avoir assez pour se procurer un programmeur
 */

public class ShopFragment extends Fragment {

    private static ListView shopListView;
    protected String[] farmers;
    protected Integer[] images;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shop_fragment, container, false);
        farmers = ShopFragmentInterface.farmers;
        images = ShopFragmentInterface.images;

        CustomListShop adapter = new CustomListShop(getActivity(), farmers, images);
        shopListView = (ListView) view.findViewById(R.id.listView);
        shopListView.setAdapter(adapter);
        shopListView.setOnItemClickListener(
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
        //On vérifie si l'usager possède assez de crédit pour acheter un programmeur
        if(MainActivity.getUser().findSpecificAmountMonnaie(Wallet.Currency.values()[position], GameValues.PRIX_DE_BASE)) {
            MainActivity.getUser().removeSpecificAmountMonnaie(Wallet.Currency.values()[position], GameValues.PRIX_DE_BASE);
            MainActivity.getUser().addFarmer(Team.Programmers.values()[position]);

            // Mise à jour de mes listeViews
            ((BaseAdapter) shopListView.getAdapter()).notifyDataSetChanged();
            ((BaseAdapter) ProgrammersFragment.getListViewofProgrammers().getAdapter()).notifyDataSetChanged();
        }
        else {
            Toast.makeText(getContext(), getString(R.string.not_enough_money) + farmers[position], Toast.LENGTH_SHORT).show();
        }

    }

    public static ListView getShopListView() {
        return shopListView;
    }

    public static void setShopListView(ListView shopListView) {
        ShopFragment.shopListView = shopListView;
    }
}
