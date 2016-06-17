package com.example.content.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.example.content.Adapter.InfoAdapter;
import com.example.content.Model.InfoModel;
import com.example.content.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SMK Telkom SP Malang on 17/06/2016.
 */
public class InformationClock extends AppCompatActivity {

    public static final String[] title = new String[]{
            "Prague", "Muambai", "Malang", "Prague", "Muambai"};

    public static final String[] location = new String[]{
            "Asia/Prague",
            "Asia/Prague",
            "Asia/Prague",
            "Asia/Prague",
            "Asia/Prague"};

    public static final String[] distance = new String[]{
            "Today",
            "Today",
            "Today",
            "Today",
            "Today"};
    ListView listView;
    List<com.example.content.Model.InfoModel> InfoModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.world_clock_list);
        Toolbar bar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(bar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("World Clock");


        InfoModel = new ArrayList<InfoModel>();
        for (int i = 0; i < location.length; i++) {
            com.example.content.Model.InfoModel item = new InfoModel(title[i], location[i], distance[i]);
            InfoModel.add(item);
        }

        listView = (ListView) findViewById(R.id.list_view);
        InfoAdapter adapter = new InfoAdapter(this,
                R.layout.world_clock_item, InfoModel);
        listView.setAdapter(adapter);
    }
}

