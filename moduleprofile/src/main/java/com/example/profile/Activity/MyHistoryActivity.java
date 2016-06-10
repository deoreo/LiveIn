package com.example.profile.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.profile.R;

/**
 * Created by User on 6/8/2016.
 */
public class MyHistoryActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_history);
    }
    public void let(View view)
    {
        Toast.makeText(MyHistoryActivity.this, "OKAII LET'S GO!!", Toast.LENGTH_SHORT).show();
    }}
