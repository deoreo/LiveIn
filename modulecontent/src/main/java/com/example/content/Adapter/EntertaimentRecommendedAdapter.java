package com.example.content.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.content.Activity.GettingToKnowDetail;
import com.example.content.Activity.EntertaimentRecommendedDetail;
import com.example.content.Controller.AppController;
import com.example.content.Model.RecommendedItem;
import com.example.content.Model.RecommendedModel;
import com.example.content.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by M. Asrof Bayhaqqi on 6/8/2016.
 */
public class EntertaimentRecommendedAdapter extends RecyclerView.Adapter<EntertaimentRecommendedAdapter.ViewHolder> {

    private ImageLoader imageLoader = AppController.getInstance().getImageLoader();
    private Context context;
    List<RecommendedModel> recommendedItems;

    public EntertaimentRecommendedAdapter(List<RecommendedModel> recommendedItems, Context context) {
        super();
        this.recommendedItems = recommendedItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recommended_item_new, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        RecommendedModel recommendedItem = recommendedItems.get(i);
        imageLoader = AppController.getInstance().getImageLoader();
        viewHolder.avatar.setImageUrl(recommendedItem.getAvatar(), imageLoader);

        viewHolder.name.setText(recommendedItem.getName());
        viewHolder.address.setText(recommendedItem.getAddress());
        viewHolder.category.setText(recommendedItem.getSubcategory());
        viewHolder.distance.setText(recommendedItem.getDistance());
        viewHolder.info.setText(recommendedItem.getInfo());
        viewHolder.rating.setRating(Float.parseFloat(recommendedItem.getRating()));
        viewHolder.list.setTag(i);
    }

    @Override
    public int getItemCount() {
        return recommendedItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public NetworkImageView avatar;
        public TextView name;
        public TextView address;
        public TextView category;
        public TextView distance;
        public TextView info;
        public RatingBar rating;
        public CardView list;

        public ViewHolder(final View itemView) {
            super(itemView);

            avatar = (NetworkImageView) itemView.findViewById(R.id.avatar);
            name = (TextView) itemView.findViewById(R.id.name);
            address = (TextView) itemView.findViewById(R.id.address);
            category = (TextView)itemView.findViewById(R.id.category);
            distance = (TextView)itemView.findViewById(R.id.distance);
            info = (TextView)itemView.findViewById(R.id.info);
            rating = (RatingBar) itemView.findViewById(R.id.rating);
            list = (CardView) itemView.findViewById(R.id.list);

            list.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int i = getAdapterPosition();
            RecommendedModel recommendedItem = recommendedItems.get(i);

            String idtenant = recommendedItem.getIdtenant();
            String name = recommendedItem.getName();
            String distance = recommendedItem.getDistance();

            Intent intent = new Intent(v.getContext(), EntertaimentRecommendedDetail.class);
            Bundle extras = new Bundle();
            extras.putString("id_tenant", idtenant);
            extras.putString("name", name);
            extras.putString("distance", distance);
            intent.putExtras(extras);
            intent.putExtras(extras);
            v.getContext().startActivity(intent);
        }
    }
}