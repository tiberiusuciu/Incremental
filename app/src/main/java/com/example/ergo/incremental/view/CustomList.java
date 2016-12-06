package com.example.ergo.incremental.view;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ergo.incremental.R;

/**
 * Ici repose ma facon specifique pour gerer ma liste de ma boutique
 */

public class CustomList extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] farmerNames;
    private final String[] farmerCost;
    private final String[] farmerPerformance;
    private final Integer[] imageId;
    public CustomList(Activity context, String[] farmerNames, String[] farmerCost, String[] farmerPerformance, Integer[] imageId) {
        super(context, R.layout.shop_list_single, farmerNames);
        this.context = context;
        this.farmerNames = farmerNames;
        this.farmerCost = farmerCost;
        this.farmerPerformance = farmerPerformance;
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

        mainText.setText(farmerNames[position]);
        priceText.setText("2 " + farmerCost[position]);
        subText.setText(farmerPerformance[position]);
        imageView.setImageResource(imageId[position]);

        if(MainActivity.user.findSpecificAmountMonnaie(farmerCost[position], 2)) {
            mainText.setTextColor(getContext().getResources().getColor(R.color.gold));
        }
        //Todo: to implement
        //imageView.setImageResource(imageId[position]);
        return rowView;
    }
}
