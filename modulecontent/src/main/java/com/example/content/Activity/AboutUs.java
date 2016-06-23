package com.example.content.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.content.Controller.AppConfig;
import com.example.content.Controller.AppController;
import com.example.content.R;
import com.example.content.Util.ConnUtil;
import com.google.android.gms.vision.text.Line;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AboutUs extends AppCompatActivity {

    Toolbar bar;
    private static String TAG = AboutUs.class.getSimpleName();

    // textview to show the parsed response
    private TextView city_name, city_area, metro_area, resident_population,
            employment_population, jobs_population, jobs_information, trees_information,
            roads_information, house_information, shop_house_information, school_information,
            international_school_information, service_apartment_information, timezone,
            area_code, vehicle_regitration, website;

    private LinearLayout linearLayout;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        // Set toolbar
        bar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(bar);
        getSupportActionBar().setTitle("About Us");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        initView();



    }

    // Initialization view
    private void initView() {
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        city_name = (TextView) findViewById(R.id.city_name);
        city_area = (TextView) findViewById(R.id.city_area);
        metro_area = (TextView) findViewById(R.id.metro_area);
        resident_population = (TextView) findViewById(R.id.resident_population);
        employment_population = (TextView) findViewById(R.id.employment_population);
        jobs_population = (TextView) findViewById(R.id.jobs_population);
        jobs_information = (TextView) findViewById(R.id.jobs_information);
        trees_information = (TextView) findViewById(R.id.trees_information);
        roads_information = (TextView) findViewById(R.id.roads_information);
        house_information = (TextView) findViewById(R.id.house_information);
        shop_house_information = (TextView) findViewById(R.id.shop_house_information);
        school_information = (TextView) findViewById(R.id.school_information);
        international_school_information = (TextView) findViewById(R.id.international_school_information);
        service_apartment_information = (TextView) findViewById(R.id.service_apartment_information);
        timezone = (TextView) findViewById(R.id.timezone);
        area_code = (TextView) findViewById(R.id.area_code);
        vehicle_regitration = (TextView) findViewById(R.id.vehicle_regitration);
        website = (TextView) findViewById(R.id.website);

        city_name.setText("Lippo Cikarang");
        city_area.setText("0000 km2 (0000 sq mi)");
        metro_area.setText("0000 km2 (0000 sq mi)");
        resident_population.setText("47.700 People");
        employment_population.setText("448.000 People");
        jobs_population.setText("89.600 Jobs");
        jobs_information.setText("89.600 Jobs");
        trees_information.setText("93.800 trees");
        roads_information.setText("281 km");
        house_information.setText("14.000 units of built houses");
        shop_house_information.setText("1216 units");
        school_information.setText("21 Schools with ");
        international_school_information.setText("2 International Schools");
        service_apartment_information.setText("920 industries");
        timezone.setText("WIB (UTC+7)");
        area_code.setText("+62 21");
        vehicle_regitration.setText("B");
        website.setText("www.lippo-cikarang.co.id");
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_about, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       if (id == R.id.profile) {
            Toast.makeText(getApplicationContext(), "Profile", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.map) {
            Toast.makeText(getApplicationContext(), "MapDetail", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.download) {
            Toast.makeText(getApplicationContext(), "Download", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == android.R.id.home) {
            Intent intent_about_us = new Intent(AboutUs.this, Home.class);
            startActivity(intent_about_us);
            AboutUs.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent_about_us = new Intent(AboutUs.this, Home.class);
        startActivity(intent_about_us);
        AboutUs.this.finish();
    }
}
