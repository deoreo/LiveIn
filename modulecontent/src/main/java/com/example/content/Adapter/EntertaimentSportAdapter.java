package com.example.content.Adapter;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.content.Controller.AppController;
import com.example.content.Model.SubCategoryItem;
import com.example.content.Model.SubCategoryModel;
import com.example.content.R;

import java.util.List;

/**
 * Created by M. Asrof Bayhaqqi on 6/9/2016.
 */
public class EntertaimentSportAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<SubCategoryModel> artItems;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public EntertaimentSportAdapter(Activity activity, List<SubCategoryModel> artItems) {
        this.activity = activity;
        this.artItems = artItems;
    }

    @Override
    public int getCount() {
        return artItems.size();
    }

    @Override
    public Object getItem(int location) {
        return artItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.sub_category_item_new, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        NetworkImageView avatar = (NetworkImageView) convertView
                .findViewById(R.id.avatar);
        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView address = (TextView) convertView.findViewById(R.id.address);
        TextView distance = (TextView) convertView.findViewById(R.id.distance);

        // getting movie data for the row
        SubCategoryModel entertaiment = artItems.get(position);

        // thumbnail image
        avatar.setImageUrl(entertaiment.getAvatar(), imageLoader);

        // name
        name.setText(entertaiment.getName());

        // address
        address.setText(entertaiment.getAddress());

        distance.setText(entertaiment.getDistance()+" KM");

        return convertView;
    }
}