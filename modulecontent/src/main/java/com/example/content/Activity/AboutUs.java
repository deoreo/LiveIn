package com.example.content.Activity;

import android.app.ProgressDialog;
import android.content.Context;
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

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class AboutUs extends AppCompatActivity {

    Toolbar bar;
    private static String TAG = AboutUs.class.getSimpleName();

    // Progress dialog
    private ProgressDialog pDialog;

    // textview to show the parsed response
    private TextView city_name, city_area, metro_area, resident_population,
            employment_population, jobs_population, jobs_information, trees_information,
            roads_information, house_information, shop_house_information, school_information,
            international_school_information, service_apartment_information, timezone,
            area_code, vehicle_regitration, website;

    private View border_area, border_population, border_information;
    private SwipeRefreshLayout mSwipeRefreshLayout;
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
        initPDialog();
        initView();
        //downData();
    }

    // Initialization view
    private void initView() {
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        relativeLayout.setVisibility(View.INVISIBLE);
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
    }

    // Initialization progress dialog
    private void initPDialog() {
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.setCanceledOnTouchOutside(false);
    }

    // Download data
    private void downData()
    {
        if(!ConnUtil.isNetConnected(this))
        {
            showErrorConnection();
            return;
        }
        sendRequest();
    }

    // Seng Request GET
    private void sendRequest() {

        showpDialog();

        JsonArrayRequest req = new JsonArrayRequest(AppConfig.URL_ABOUS_US,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());

                        try {
                            // Parsing json array response
                            // loop through each json object
                            for (int i = 0; i < response.length(); i++) {

                                JSONObject city = (JSONObject) response
                                        .get(i);
                                relativeLayout.setVisibility(View.VISIBLE);
                                city_name.setText(city.getString("city_name"));
                                city_area.setText(city.getString("city_area") + " km2");
                                metro_area.setText(city.getString("metro_area") +  " km2");
                                resident_population.setText(city.getString("resident_population") +  " People");
                                employment_population.setText(city.getString("employment_population") +  " People");
                                jobs_population.setText(city.getString("jobs_population") +  " Jobs");
                                jobs_information.setText(city.getString("jobs_information") +  " Jobs");
                                trees_information.setText(city.getString("trees_information") +  " Trees");
                                roads_information.setText(city.getString("roads_information") +  " km");
                                house_information.setText(city.getString("house_information") +  " units of built houses");
                                shop_house_information.setText(city.getString("shop_house_information") +  " units");
                                school_information.setText(city.getString("school_information") +  " Schools with ");
                                international_school_information.setText(city.getString("international_school_information") +  " International Schools");
                                service_apartment_information.setText(city.getString("service_apartment_information") + " industries");
                                timezone.setText(city.getString("timezone"));
                                area_code.setText(city.getString("area_code"));
                                vehicle_regitration.setText(city.getString("vehicle_regitration"));
                                website.setText(city.getString("website"));
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(),
                                    "Error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }

                        hidepDialog();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();
                hidepDialog();
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(req);
    }

    // Show dialog
    private void showpDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    // Hide dialog
    private void hidepDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

    // Show snackbar error
    private void showErrorConnection() {
        Snackbar snackbar = Snackbar
                .make(linearLayout, "No internet connection!", Snackbar.LENGTH_LONG)
                .setAction("RETRY", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        downData();
                    }
                });

        // Changing message text color
        snackbar.setActionTextColor(Color.RED);

        // Changing action button text color
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.YELLOW);
        snackbar.show();
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
        if (id == R.id.search) {
            Toast.makeText(getApplicationContext(), "Search", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.refresh) {
            //downData();
            return true;
        } else if (id == R.id.profile) {
            Toast.makeText(getApplicationContext(), "Profile", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.map) {
            Toast.makeText(getApplicationContext(), "Map", Toast.LENGTH_SHORT).show();
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

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
