package com.example.content.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.content.R;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by SMK Telkom SP Malang on 10/06/2016.
 */
public class EntertaimentLeisureDetail extends AppCompatActivity {

    Toolbar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub_category_detail);

        // Get data intent
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String get_idtenant = extras.getString("id_tenant");
        String get_name = extras.getString("name");
        String get_distance = extras.getString("distance");

        String msg = "id_tenant: " + get_idtenant + "\n"
                + "distance: " + get_distance  + "\n"
                + "name: " + get_name  + "\n";

        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_LONG).show();

        bar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(bar);

        getSupportActionBar().setTitle(get_name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home){
            this.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}