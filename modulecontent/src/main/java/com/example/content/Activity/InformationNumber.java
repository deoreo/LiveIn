package com.example.content.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.example.content.Adapter.NumberAdapter;
import com.example.content.Model.NumberModel;
import com.example.content.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SMK Telkom SP Malang on 17/06/2016.
 */
public class InformationNumber extends AppCompatActivity{

    public static final String[] title = new String[]{
            "Pemadam Kebakaran", "Polsek Cikarang", "Ambulance", "Ambulance", "Pemadam Kebakaran"};

    ListView listView;
    List<com.example.content.Model.NumberModel> NumberModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.number_list);
        Toolbar bar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(bar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Helpful Numbers");


        NumberModel = new ArrayList<NumberModel>();
        for (int i = 0; i < title.length; i++) {
            com.example.content.Model.NumberModel item = new NumberModel(title[i]);
            NumberModel.add(item);
        }

        listView = (ListView) findViewById(R.id.list_view);
        NumberAdapter adapter = new NumberAdapter(this,
                R.layout.world_clock_item, NumberModel);
        listView.setAdapter(adapter);
    }
}
