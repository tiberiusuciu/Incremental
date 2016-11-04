package com.example.ergo.incremental;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Ici repose ma facon specifique pour gerer ma liste de ma boutique
 */

public class CustomList extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] web;
    private final Integer[] imageId;
    public CustomList(Activity context, String[] web, Integer[] imageId) {
        super(context, R.layout.shop_list_single, web);
        this.context = context;
        this.web = web;
        this.imageId = imageId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.shop_list_single, null, true);

        TextView mainText = (TextView) rowView.findViewById(R.id.textView);
        TextView subText = (TextView) rowView.findViewById(R.id.subTextView);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView);

        mainText.setText(web[position]);
        //to implement
        //subText.setText(anotherWeb[position]);
        //imageView.setImageResource(imageId[position]);
        return rowView;
    }
}
