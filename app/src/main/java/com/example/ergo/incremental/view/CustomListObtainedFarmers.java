package com.example.ergo.incremental.view;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ergo.incremental.R;

/**
 * Created by ergo on 03/12/16.
 */

public class CustomListObtainedFarmers extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] farmerNames;

    public CustomListObtainedFarmers(Activity context, String[] farmerNames) {
        super(context, R.layout.obtained_farmer_list_single, farmerNames);
        this.context = context;
        this.farmerNames = farmerNames;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.obtained_farmer_list_single, null, true);

        TextView mainText = (TextView) rowView.findViewById(R.id.textView);
        TextView priceText = (TextView) rowView.findViewById(R.id.amount);

        mainText.setText(farmerNames[position]);
        priceText.setText(MainActivity.user.countAllInstancesOfSpecificFarmer(farmerNames[position]) + "");
        return rowView;
    }
}
