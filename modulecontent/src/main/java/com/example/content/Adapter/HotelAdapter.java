package com.example.content.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.content.Controller.AppController;
import com.example.content.Model.Hotel;
import com.example.content.R;

import java.util.List;

/**
 * Created by M. Asrof Bayhaqqi on 6/15/2016.
 */
public class HotelAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Hotel> hotelItems;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public HotelAdapter(Activity activity, List<Hotel> hotelItems) {
        this.activity = activity;
        this.hotelItems = hotelItems;
    }

    @Override
    public int getCount() {
        return hotelItems.size();
    }

    @Override
    public Object getItem(int location) {
        return hotelItems.get(location);
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
            convertView = inflater.inflate(R.layout.hotel_item, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        NetworkImageView avatar = (NetworkImageView) convertView
                .findViewById(R.id.avatar);
        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView address = (TextView) convertView.findViewById(R.id.address);
        TextView phone = (TextView) convertView.findViewById(R.id.phone);

        // getting movie data for the row
        Hotel hotel = hotelItems.get(position);

        // thumbnail image
        avatar.setImageUrl(hotel.getAvatar(), imageLoader);

        // name
        name.setText(hotel.getName());

        // address
        address.setText(hotel.getAddress());

        // phone
        phone.setText(hotel.getPhone());

        return convertView;
    }
}
