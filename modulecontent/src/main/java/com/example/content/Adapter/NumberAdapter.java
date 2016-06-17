package com.example.content.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.content.Model.NumberModel;
import com.example.content.R;

import java.util.List;

/**
 * Created by SMK Telkom SP Malang on 17/06/2016.
 */
public class NumberAdapter extends ArrayAdapter<NumberModel> {

    Context context;

    public NumberAdapter(Context context, int resourceId,
                       List<NumberModel> items) {
        super(context, resourceId, items);
        this.context = context;
    }

    /*private view holder class*/
    private class ViewHolder {
        TextView title;

        RelativeLayout list;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        NumberModel numberModel = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.number_item, null);
            holder = new ViewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.name);
            holder.list = (RelativeLayout) convertView.findViewById(R.id.list);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        holder.title.setText(numberModel.getTitle());

        return convertView;
    }

}
