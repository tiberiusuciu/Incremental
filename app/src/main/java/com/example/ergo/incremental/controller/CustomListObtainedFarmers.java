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
import com.example.ergo.incremental.model.Team;


public class CustomListObtainedFarmers extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] farmerNames;
    private final Integer[] imageId;
    public CustomListObtainedFarmers(Activity context, String[] farmerNames, Integer[] imageId) {
        super(context, R.layout.obtained_farmer_list_single, farmerNames);
        this.context = context;
        this.farmerNames = farmerNames;
        this.imageId = imageId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.obtained_farmer_list_single, null, true);

        TextView mainText = (TextView) rowView.findViewById(R.id.textView);
        TextView priceText = (TextView) rowView.findViewById(R.id.amount);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView);


        mainText.setText(farmerNames[position]);
        priceText.setText(MainActivity.user.countAllInstancesOfSpecificFarmer(Team.Programmers.values()[position]) + "");
        imageView.setImageResource(imageId[position]);
        return rowView;
    }
}
