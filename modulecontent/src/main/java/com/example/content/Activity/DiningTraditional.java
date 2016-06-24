package com.example.content.Activity;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;

import com.example.content.Adapter.DiningTraditionalAdapter;
import com.example.content.Controller.AppConfig;
import com.example.content.Controller.AppController;
import com.example.content.Controller.AppData;
import com.example.content.Model.SubCategoryItem;
import com.example.content.Model.SubCategoryModel;
import com.example.content.R;
import com.example.content.Util.ConnUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by SMK Telkom SP Malang on 10/06/2016.
 */
public class DiningTraditional extends AppCompatActivity implements
        AdapterView.OnItemClickListener {

    private static final String TAG = DiningTraditional.class.getSimpleName();
    private List<SubCategoryModel> dinList = new ArrayList<SubCategoryModel>();
    private ListView listView;
    private DiningTraditionalAdapter adapter;
    private Toolbar bar;
    private LinearLayout linearLayout;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    Spinner spinner_category, spinner_sort;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub_category_new);

        bar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(bar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tradisional");


        initView();
        initSwipeRefresh();
        initListView();
        initSpinner();
        downData();
    }

    private void downData() {
        if (!ConnUtil.isNetConnected(this)) {
            showErrorConnection();
            mSwipeRefreshLayout.setRefreshing(false);
            return;
        }
        sendRequest();
        mSwipeRefreshLayout.setRefreshing(false);
    }



    private void sendRequest() {

        JsonArrayRequest stringRequest = new JsonArrayRequest(AppConfig.URL_DINING + "11",
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());

                        // clear art in art array for update and add new art
                        dinList.clear();

                        try {
                            // Parsing json array response
                            // loop through each json object
                            for (int i = 0; i < response.length(); i++) {



                                JSONObject obj = response.getJSONObject(i);

                                SubCategoryModel dinjap = new SubCategoryModel();
                                dinjap.setIdtenant(obj.getString("id_tenant"));
                                dinjap.setAvatar(obj.getString("avatar"));
                                dinjap.setName(obj.getString("name"));
                                dinjap.setAddress(obj.getString("address"));
                                dinjap.setLatitude(obj.getString("latitude"));
                                dinjap.setLongitude(obj.getString("longitude"));
                                double longtitude = Double.parseDouble(obj.getString("longitude"));
                                double latitude = Double.parseDouble(obj.getString("latitude"));
                                int distance = calculateDistance(latitude,longtitude);
                                dinjap.setDistance(""+distance+" KM");
                                dinjap.setSubcategory(obj.getString("subcategory"));
                                dinList.add(dinjap);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(),
                                    "Error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                        // notifying list adapter about data changes
                        // so that it renders the list view with updated data
                        adapter.notifyDataSetChanged();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();
            }


        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                String credentials = "admin:1234";
                String auth = "Basic " + Base64.encodeToString(credentials.getBytes(),    Base64.NO_WRAP);
                headers.put("Content-Type", "application/json");
                headers.put("Authorization", auth);
                return headers;
            }
        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(stringRequest);
    }

    private int calculateDistance(double latitude, double longitude){
        Location locationA = new Location("point A");

        locationA.setLatitude(AppData.myLatitude);
        locationA.setLongitude(AppData.myLongitude);

        Location locationB = new Location("point B");

        locationB.setLatitude(latitude);
        locationB.setLongitude(longitude);

        float distanceInMeters = locationA.distanceTo(locationB)/1000;
        Integer distanceInKM = Math.round(distanceInMeters);

        return distanceInKM;
    }

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

    private void initListView() {
        listView = (ListView) findViewById(R.id.list_view);
        adapter = new DiningTraditionalAdapter(this, dinList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    private void initSwipeRefresh() {
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swiperefresh);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorPrimaryDark, R.color.colorAccent);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                downData();
            }
        });
        mSwipeRefreshLayout.setRefreshing(true);
    }

    //inialize initvieq
    private void initView() {
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
    }

    // Initialization spinner
    private void initSpinner() {
        spinner_category = (Spinner) findViewById(R.id.spinner_category);
        spinner_category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            //get strings of first item
            String firstItem = String.valueOf(spinner_category.getSelectedItem());

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (firstItem.equals(String.valueOf(spinner_category.getSelectedItem()))) {
                    // ToDo when first item is selected
                } else {
                    Toast.makeText(parent.getContext(),
                            "You have selected : " + parent.getItemAtPosition(position).toString(),
                            Toast.LENGTH_LONG).show();
                    // Todo when item is selected by the user
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner_sort = (Spinner) findViewById(R.id.spinner_sort);
        spinner_sort.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            //get strings of first item
            String firstItem = String.valueOf(spinner_sort.getSelectedItem());

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (firstItem.equals(String.valueOf(spinner_sort.getSelectedItem()))) {
                    // ToDo when first item is selected
                } else {
                    Toast.makeText(parent.getContext(),
                            "You have selected : " + parent.getItemAtPosition(position).toString(),
                            Toast.LENGTH_LONG).show();
                    // Todo when item is selected by the user
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        /*Toast toast = Toast.makeText(getApplicationContext(),
                "Item " + (position + 1) + ": " + SubCategoryItem.get(position),
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();*/

        switch (position) {
            case 0:
                /*Snackbar.make(listView, "Position : " + getPosition(), Snackbar.LENGTH_LONG).show();*/
                Intent intent_traditional0 = new Intent(getApplicationContext(), DiningTraditionalDetail.class);
                startActivity(intent_traditional0);
                break;
            case 1:
                /*Snackbar.make(listView, "Position : " + getPosition(), Snackbar.LENGTH_LONG).show();*/
                Intent intent_traditional1 = new Intent(getApplicationContext(), DiningTraditionalDetail.class);
                startActivity(intent_traditional1);
                break;
            case 2:
               /*Snackbar.make(listView, "Position : " + getPosition(), Snackbar.LENGTH_LONG).show();*/
                Intent intent_traditional2 = new Intent(getApplicationContext(), DiningTraditionalDetail.class);
                startActivity(intent_traditional2);
                break;
            case 3:
               /*Snackbar.make(listView, "Position : " + getPosition(), Snackbar.LENGTH_LONG).show();*/
                Intent intent_traditional3 = new Intent(getApplicationContext(), DiningTraditionalDetail.class);
                startActivity(intent_traditional3);
                break;
            case 4:
               /*Snackbar.make(listView, "Position : " + getPosition(), Snackbar.LENGTH_LONG).show();*/
                Intent intent_traditional4 = new Intent(getApplicationContext(), DiningTraditionalDetail.class);
                startActivity(intent_traditional4);
                break;
            case 5:
               /*Snackbar.make(listView, "Position : " + getPosition(), Snackbar.LENGTH_LONG).show();*/
                Intent intent_traditional5 = new Intent(getApplicationContext(), DiningTraditionalDetail.class);
                startActivity(intent_traditional5);
                break;
            case 6:
               /*Snackbar.make(listView, "Position : " + getPosition(), Snackbar.LENGTH_LONG).show();*/
                Intent intent_traditional6 = new Intent(getApplicationContext(), DiningTraditionalDetail.class);
                startActivity(intent_traditional6);
                break;
        }


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        // Inflate menu to add items to action bar if it is present.
        inflater.inflate(R.menu.menu_main, menu);
        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));
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
        } else if (id == R.id.profile) {
            Toast.makeText(getApplicationContext(), "Profile", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.map) {
            Toast.makeText(getApplicationContext(), "MapDetail", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.download) {
            Toast.makeText(getApplicationContext(), "Download", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == android.R.id.home) {
            this.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}