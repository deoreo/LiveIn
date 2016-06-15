package com.example.content.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.content.Activity.PublicServicesPropertyAgentsDetail;
import com.example.content.Model.SubCategoryItem;
import com.example.content.R;

import java.util.List;

/**
 * Created by SMK Telkom SP Malang on 10/06/2016.
 */
public class PublicServicesPropertyAgentsAdapter extends ArrayAdapter<SubCategoryItem> {

    Context context;

    public PublicServicesPropertyAgentsAdapter(Context context, int resourceId,
                                               List<SubCategoryItem> items) {
        super(context, resourceId, items);
        this.context = context;
    }

    /*private view holder class*/
    private class ViewHolder {
        ImageView thumbnail;
        TextView title;
        TextView location;
        TextView distance;
        RelativeLayout list;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        SubCategoryItem SubCategoryItem = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.sub_category_item, null);
            holder = new ViewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.location = (TextView) convertView.findViewById(R.id.location);
            holder.distance = (TextView) convertView.findViewById(R.id.distance);
            holder.thumbnail = (ImageView) convertView.findViewById(R.id.thumbnail);
            holder.list = (RelativeLayout) convertView.findViewById(R.id.list);
            convertView.setTag(holder);

            holder.list.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (position){
                        case 0:
                            /*Snackbar.make(list, "Position : " + getPosition(), Snackbar.LENGTH_LONG).show();*/
                            Intent intent_property_agents0 = new Intent(v.getContext(), PublicServicesPropertyAgentsDetail.class);
                            v.getContext().startActivity(intent_property_agents0);
                            break;
                        case 1:
                            /*Snackbar.make(list, "Position : " + getPosition(), Snackbar.LENGTH_LONG).show();*/
                            Intent intent_property_agents1 = new Intent(v.getContext(), PublicServicesPropertyAgentsDetail.class);
                            v.getContext().startActivity(intent_property_agents1);
                            break;
                        case 2:
                            /*Snackbar.make(list, "Position : " + getPosition(), Snackbar.LENGTH_LONG).show();*/
                            Intent intent_property_agents2 = new Intent(v.getContext(), PublicServicesPropertyAgentsDetail.class);
                            v.getContext().startActivity(intent_property_agents2);
                            break;
                    }
                }
            });
        } else
            holder = (ViewHolder) convertView.getTag();

        holder.title.setText(SubCategoryItem.getTitle());
        holder.location.setText(SubCategoryItem.getLocation());
        holder.distance.setText(SubCategoryItem.getDistance());
        holder.thumbnail.setImageResource(SubCategoryItem.getThumbnail());

        return convertView;
    }

}