package com.example.content.Activity;

import android.Manifest;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
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
import com.example.content.Adapter.EntertaimentArtAdapter;
import com.example.content.Adapter.EntertaimentEventsAdapter;
import com.example.content.Controller.AppConfig;
import com.example.content.Controller.AppController;
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
public class EntertaimentEvents extends AppCompatActivity implements
        AdapterView.OnItemClickListener, LocationListener {

    // Log tag
    private static final String TAG = EntertaimentEvents.class.getSimpleName();

    private List<SubCategoryModel> artList = new ArrayList<SubCategoryModel>();
    private ListView listView;
    private EntertaimentEventsAdapter adapter;
    private Toolbar bar;
    private LinearLayout linearLayout;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    Spinner spinner_category, spinner_sort;

    //Location
    protected LocationManager locationManager;
    private static double cur_latitude;
    private static double cur_longitude;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub_category_new);

        bar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(bar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Events");

        initLocation();
        initView();
        initSwipeRefresh();
        initListView();
        initSpinner();
        downData();
    }

    // Initialization location
    private void initLocation() {
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        /*locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, (LocationListener) this);*/
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if(location != null) {
            cur_latitude = location.getLatitude();
            cur_longitude = location.getLongitude();
            String msg = "New Latitude: " + location.getLatitude() + "\n"
                    + "New Longitude: " + location.getLongitude();

            Toast.makeText(getBaseContext(), msg, Toast.LENGTH_LONG).show();
            downData();
        } else {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
            downData();
        }
    }

    private int calculateDistance(double latitude, double longitude){
        Location locationA = new Location("point A");

        locationA.setLatitude(cur_latitude);
        locationA.setLongitude(cur_longitude);

        Location locationB = new Location("point B");

        locationB.setLatitude(latitude);
        locationB.setLongitude(longitude);

        float distanceInMeters = locationA.distanceTo(locationB)/1000;
        Integer distanceInKM = Math.round(distanceInMeters);

        return distanceInKM;
    }

    @Override
    public void onLocationChanged(Location location) {
        String msg = "New Latitude: " + location.getLatitude() + "\n"
                + "New Longitude: " + location.getLongitude();

        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_LONG).show();

        cur_latitude = location.getLatitude();
        cur_longitude = location.getLongitude();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onProviderEnabled(String provider) {
        Toast.makeText(getBaseContext(), R.string.gps_on,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProviderDisabled(String provider) {
        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        startActivity(intent);
        Toast.makeText(getBaseContext(), R.string.gps_off,
                Toast.LENGTH_SHORT).show();
    }

    // Initialization view
    private void initView() {
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
    }

    // Initialization swiperefresh
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

    // Initialization listview
    private void initListView() {
        listView = (ListView) findViewById(R.id.list_view);
        adapter = new EntertaimentEventsAdapter(this, artList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    // Download data
    private void downData() {
        if (!ConnUtil.isNetConnected(this)) {
            showErrorConnection();
            return;
        }
        sendRequest();
    }

    // Seng Request GET
    private void sendRequest() {

        JsonArrayRequest stringRequest = new JsonArrayRequest(AppConfig.URL_TENANT+"14",
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());

                        // clear art in art array for update and add new art
                        artList.clear();

                        try {
                            // Parsing json array response
                            // loop through each json object
                            for (int i = 0; i < response.length(); i++) {

                                JSONObject obj = response.getJSONObject(i);
                                SubCategoryModel art = new SubCategoryModel();
                                art.setIdtenant(obj.getString("id_tenant"));
                                art.setAvatar(obj.getString("avatar"));
                                art.setName(obj.getString("name"));
                                art.setAddress(obj.getString("address"));
                                art.setLatitude(obj.getString("latitude"));
                                art.setLongitude(obj.getString("longitude"));
                                double longtitude = Double.parseDouble(obj.getString("longitude"));
                                double latitude = Double.parseDouble(obj.getString("latitude"));
                                int distance = calculateDistance(latitude,longtitude);
                                art.setDistance(""+distance+" KM");
                                art.setSubcategory(obj.getString("subcategory"));
                                artList.add(art);
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
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();
                mSwipeRefreshLayout.setRefreshing(false);
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

    // Show snackbar error
    private void showErrorConnection() {
        Snackbar snackbar = Snackbar
                .make(linearLayout, R.string.no_connection, Snackbar.LENGTH_LONG)
                .setAction(R.string.retry, new View.OnClickListener() {
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
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String idtenant = artList.get(position).getIdtenant();
        String name = artList.get(position).getName();
        /*Snackbar.make(listView, "ID Tenant : " + id_tenant, Snackbar.LENGTH_LONG).show();*/
        Intent intent = new Intent(EntertaimentEvents.this, EntertaimentEventsDetail.class);
        Bundle extras = new Bundle();
        extras.putString("id_tenant", idtenant);
        extras.putString("name", name);
        intent.putExtras(extras);
        startActivity(intent);
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
            Toast.makeText(getApplicationContext(), "Map", Toast.LENGTH_SHORT).show();
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