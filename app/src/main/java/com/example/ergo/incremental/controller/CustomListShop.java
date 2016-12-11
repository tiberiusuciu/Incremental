package com.example.ergo.incremental.controller;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ergo.incremental.R;
import com.example.ergo.incremental.model.ProgrammersPerformance;
import com.example.ergo.incremental.model.Team;
import com.example.ergo.incremental.model.Wallet;
import com.example.ergo.incremental.model.utils.ProgrammersStats;

/**
 * Ici repose ma facon specifique pour gerer ma liste de ma boutique
 */

public class CustomListShop extends ArrayAdapter<String> {

    private final Activity context;
    private final Integer[] imageId;

    public CustomListShop(Activity context, String[] farmerNames, Integer[] imageId) {
        super(context, R.layout.shop_list_single, farmerNames);
        this.context = context;
        this.imageId = imageId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.shop_list_single, null, true);

        TextView mainText = (TextView) rowView.findViewById(R.id.textView);
        TextView subText = (TextView) rowView.findViewById(R.id.subTextView);
        TextView priceText = (TextView) rowView.findViewById(R.id.price);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView);

        mainText.setText(Team.Programmers.values()[position] + "");
        subText.setText(ProgrammersPerformance.getPerformanceOfProgrammer(Team.Programmers.values()[position]) + " " + ProgrammersStats.PERFORMANCE_UNIT);
        priceText.setText("2 " + Wallet.Currency.values()[position]);
        imageView.setImageResource(imageId[position]);

        // Si l'usager peut acheter un  programmeur, alors on affichera son nom en or
        if(MainActivity.getUser().findSpecificAmountMonnaie(Wallet.Currency.values()[position], 2)) {
            mainText.setTextColor(getContext().getResources().getColor(R.color.gold));
        }

        return rowView;
    }
}
