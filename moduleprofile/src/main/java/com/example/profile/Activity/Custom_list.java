package com.example.profile.Activity;

/**
 * Created by Lenovo on 08/06/2016.
 */

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.profile.R;


public class Custom_list  extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] menu;
    private final Integer[] imageId;
    public Custom_list(Activity context,
                      String[] menu, Integer[] imageId) {
        super(context, R.layout.list_single, menu);
        this.context = context;
        this.menu = menu;
        this.imageId = imageId;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_single, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt_menu);
        RelativeLayout btn_profile = (RelativeLayout) rowView.findViewById(R.id.btn_profile);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        txtTitle.setText(menu[position]);

        imageView.setImageResource(imageId[position]);
        return rowView;
    }
}


