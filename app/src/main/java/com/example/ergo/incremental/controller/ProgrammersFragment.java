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
 * Ceci est le fragment qui affiche la collection de programmeurs stocké dans l'usager
 * C'est un custom list view qui indique combien de chaque programmeur l'usager possède.
 */

public class ProgrammersFragment extends Fragment {

    private static ListView listViewofProgrammers;
    protected String[] farmers;
    protected Integer[] images;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.programmers_fragment, container, false);

        farmers = ShopFragmentInterface.farmers;
        images = ShopFragmentInterface.images;

        CustomListObtainedFarmers adapter = new CustomListObtainedFarmers(getActivity(), farmers, images);
        listViewofProgrammers = (ListView) view.findViewById(R.id.listviewObtainedFarmers);
        listViewofProgrammers.setAdapter(adapter);

        return view;
    }

    public static ListView getListViewofProgrammers() {
        return listViewofProgrammers;
    }

    public static void setListViewofProgrammers(ListView listViewofProgrammers) {
        ProgrammersFragment.listViewofProgrammers = listViewofProgrammers;
    }
}
