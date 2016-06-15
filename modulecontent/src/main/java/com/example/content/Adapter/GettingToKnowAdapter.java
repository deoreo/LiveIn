package com.example.content.Adapter;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.content.Activity.GettingToKnowDetail;
import com.example.content.Model.GettingToKnowItem;
import com.example.content.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by M. Asrof Bayhaqqi on 6/8/2016.
 */
public class GettingToKnowAdapter extends RecyclerView.Adapter<GettingToKnowAdapter.ViewHolder> {

    List<GettingToKnowItem> Items;

    public GettingToKnowAdapter() {
        super();
        Items = new ArrayList<GettingToKnowItem>();
        GettingToKnowItem category = new GettingToKnowItem();

        //Card View 1
        category.setTitle("Lorem ipsum dolor sit amet, consectetur adipiscing elit");
        category.setDate("10 April 2016");
        category.setThumbnail(R.drawable.about);
        Items.add(category);

        //Card View 2
        category.setTitle("Lorem ipsum dolor sit amet, consectetur adipiscing elit");
        category.setDate("11 April 2016");
        category.setThumbnail(R.drawable.about);
        Items.add(category);

        //Card View 3
        category.setTitle("Lorem ipsum dolor sit amet, consectetur adipiscing elit");
        category.setDate("12 April 2016");
        category.setThumbnail(R.drawable.about);
        Items.add(category);

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.getting_to_know_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        GettingToKnowItem nature = Items.get(i);
        viewHolder.title.setText(nature.getTitle());
        viewHolder.date.setText(nature.getDate());
        viewHolder.thumbnail.setImageResource(nature.getThumbnail());
        viewHolder.list.setTag(viewHolder);
    }

    @Override
    public int getItemCount() {
        return Items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView thumbnail;
        public TextView title;
        public TextView date;
        public CardView list;

        public ViewHolder(final View itemView) {
            super(itemView);

            thumbnail = (ImageView)itemView.findViewById(R.id.thumbnail);
            title = (TextView)itemView.findViewById(R.id.title);
            date = (TextView)itemView.findViewById(R.id.date);
            list = (CardView)itemView.findViewById(R.id.list);

            list.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ViewHolder holder = (ViewHolder)v.getTag();
                    int position = holder.getPosition();

                    Intent intent_news = new Intent(v.getContext(), GettingToKnowDetail.class);
                    switch (position){
                        case 0:
                            /*Snackbar.make(list, "Position : " + getPosition(), Snackbar.LENGTH_LONG).show();*/
                            Intent intent_news0 = new Intent(v.getContext(), GettingToKnowDetail.class);
                            v.getContext().startActivity(intent_news0);
                            break;
                        case 1:
                            /*Snackbar.make(list, "Position : " + getPosition(), Snackbar.LENGTH_LONG).show();*/
                            Intent intent_news1 = new Intent(v.getContext(), GettingToKnowDetail.class);
                            v.getContext().startActivity(intent_news1);
                            break;
                        case 2:
                            /*Snackbar.make(list, "Position : " + getPosition(), Snackbar.LENGTH_LONG).show();*/
                            Intent intent_news2 = new Intent(v.getContext(), GettingToKnowDetail.class);
                            v.getContext().startActivity(intent_news2);
                            break;
                    }
                }
            });
        }
    }
}
