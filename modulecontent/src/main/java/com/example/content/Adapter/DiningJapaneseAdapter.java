package com.example.content.Adapter;

import android.app.Activity;
import android.content.Context;
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
import com.example.content.Activity.DiningJapanese;
import com.example.content.Controller.AppController;
import com.example.content.Model.SubCategoryItem;
import com.example.content.Model.SubCategoryModel;
import com.example.content.R;

import java.util.Comparator;
import java.util.List;

/**
 * Created by SMK Telkom SP Malang on 10/06/2016.
 */
public class DiningJapaneseAdapter extends BaseAdapter {


    private Activity activity;
    private LayoutInflater inflater;
    private List<SubCategoryModel> dinitem;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public DiningJapaneseAdapter(Activity activity, List<SubCategoryModel> dinList) {
        this.activity = activity;
        this.dinitem = dinList;
    }



    /*private view holder class*/


    @Override
    public int getCount() {
        return dinitem.size();
    }

    @Override
    public Object getItem(int location) {
        return dinitem.get(location);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    public View getView(final int position, View convertView, ViewGroup parent) {

//        SubCategoryItem SubCategoryItem = getItem(position);

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
            TextView phone = (TextView) convertView.findViewById(R.id.phone);

            // getting movie data for the row
            SubCategoryModel entertaiment = dinitem.get(position);

            // thumbnail image
            avatar.setImageUrl(entertaiment.getAvatar(), imageLoader);

            // name
            name.setText(entertaiment.getName());

            // address
            address.setText(entertaiment.getAddress());

            // phone
            phone.setText(entertaiment.getDistance());
            return convertView;

        }
    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }


}