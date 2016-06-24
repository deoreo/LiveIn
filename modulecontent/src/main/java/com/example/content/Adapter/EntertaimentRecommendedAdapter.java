package com.example.content.Adapter;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.content.Activity.DiningRecommended;
import com.example.content.Activity.GettingToKnowDetail;
import com.example.content.Activity.EntertaimentRecommendedDetail;
import com.example.content.Model.RecommendedItem;
import com.example.content.Model.RecommendedModel;
import com.example.content.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by M. Asrof Bayhaqqi on 6/8/2016.
 */
public class EntertaimentRecommendedAdapter extends RecyclerView.Adapter<EntertaimentRecommendedAdapter.ViewHolder> {

    List<RecommendedItem> Items;

    public  EntertaimentRecommendedAdapter(List<RecommendedModel> listRecomendedItem, DiningRecommended diningRecommended) {
        super();
        Items = new ArrayList<RecommendedItem>();
        RecommendedItem category = new RecommendedItem();

        //Card View 1
        category.setTitle("Title");
        category.setLocation("Location");
        category.setCategory("Category");
        category.setDistance("Distance");
        category.setInfo("Info");
        category.setStar(5);
        category.setThumbnail(R.drawable.about);
        Items.add(category);

        //Card View 2
        category.setTitle("Title");
        category.setLocation("Location");
        category.setCategory("Category");
        category.setDistance("Distance");
        category.setInfo("Info");
        category.setStar(5);
        category.setThumbnail(R.drawable.about);
        Items.add(category);

        //Card View 3
        category.setTitle("Title");
        category.setLocation("Location");
        category.setCategory("Category");
        category.setDistance("Distance");
        category.setInfo("Info");
        category.setStar(5);
        category.setThumbnail(R.drawable.about);
        Items.add(category);

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recommended_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        RecommendedItem item = Items.get(i);
        viewHolder.title.setText(item.getTitle());
        viewHolder.location.setText(item.getLocation());
        viewHolder.category.setText(item.getCategory());
        viewHolder.distance.setText(item.getDistance());
        viewHolder.info.setText(item.getInfo());
        viewHolder.star.setRating(item.getStar());
        viewHolder.thumbnail.setImageResource(item.getThumbnail());
        viewHolder.list.setTag(viewHolder);
    }

    @Override
    public int getItemCount() {
        return Items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView thumbnail;
        public TextView title;
        public TextView location;
        public TextView category;
        public TextView distance;
        public TextView info;
        public RatingBar star;
        public CardView list;

        public ViewHolder(final View itemView) {
            super(itemView);

            thumbnail = (ImageView)itemView.findViewById(R.id.thumbnail);
            title = (TextView)itemView.findViewById(R.id.title);
            location = (TextView)itemView.findViewById(R.id.location);
            category = (TextView)itemView.findViewById(R.id.category);
            distance = (TextView)itemView.findViewById(R.id.distance);
            info = (TextView)itemView.findViewById(R.id.info);
            star = (RatingBar) itemView.findViewById(R.id.rating);
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
                            Intent intent_recom_entertaiment0 = new Intent(v.getContext(), EntertaimentRecommendedDetail.class);
                            v.getContext().startActivity(intent_recom_entertaiment0);
                            break;
                        case 1:
                            /*Snackbar.make(list, "Position : " + getPosition(), Snackbar.LENGTH_LONG).show();*/
                            Intent intent_recom_entertaiment1 = new Intent(v.getContext(), EntertaimentRecommendedDetail.class);
                            v.getContext().startActivity(intent_recom_entertaiment1);
                            break;
                        case 2:
                            /*Snackbar.make(list, "Position : " + getPosition(), Snackbar.LENGTH_LONG).show();*/
                            Intent intent_recom_entertaiment2 = new Intent(v.getContext(), EntertaimentRecommendedDetail.class);
                            v.getContext().startActivity(intent_recom_entertaiment2);
                            break;
                    }
                }
            });
        }
    }
}
