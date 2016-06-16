package com.example.content.Activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.content.Adapter.HotelAdapter;
import com.example.content.Controller.AppConfig;
import com.example.content.Controller.AppController;
import com.example.content.Model.ContentManager;
import com.example.content.Model.Hotel;
import com.example.content.R;
import com.example.content.Util.ConnUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by M. Asrof Bayhaqqi on 6/15/2016.
 */
public class HotelActivity extends AppCompatActivity {
    // Log tag
    private static final String TAG = HotelActivity.class.getSimpleName();

    private ProgressDialog pDialog;
    private List<Hotel> hotelList = new ArrayList<Hotel>();
    private ListView listView;
    private HotelAdapter adapter;
    private Toolbar bar;
    private LinearLayout linearLayout;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    //private ContentManager contentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel);

        // Set toolbar
        bar = (Toolbar) findViewById(R.id.toolbar);
        Toolbar bar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(bar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Hotel");

        //contentManager = new ContentManager();

        initPDialog();
        initView();
        initSwipeRefresh();
        initListView();
        /*if(data di Sharedpref tidak ada)
        downData();
        else if(jika di share pref ada){
            hotelList = ContentManager.getListHotel();
            adapter = new HotelAdapter(this, hotelList);
            listView.setAdapter(adapter);
        }*/
    }

    // Initialization view
    private void initView() {
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
    }

    // Initialization progress dialog
    private void initPDialog() {
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.setCanceledOnTouchOutside(false);
    }

    // Initialization listview
    private void initListView() {
        listView = (ListView) findViewById(R.id.list_view);
        //hotelList = contentManager.getHotel(HotelActivity.this);
        /*
        if (hotelList.size()>0){
            adapter = new HotelAdapter(this, hotelList);
            listView.setAdapter(adapter);
        }else{
            downData();
        }*/

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int idtenant = hotelList.get(position).getIdtenant();
                String name = hotelList.get(position).getName();
                Snackbar.make(listView, "ID Tenant : " + idtenant, Snackbar.LENGTH_LONG).show();
                Intent intent = new Intent(HotelActivity.this, HotelDetail.class);
                Bundle extras = new Bundle();
                extras.putInt("idtenant", idtenant);
                extras.putString("name", name);
                intent.putExtras(extras);
                startActivity(intent);

            }
        });
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

    // Download data
    private void downData() {
        if (!ConnUtil.isNetConnected(this)) {
            showErrorConnection();
            mSwipeRefreshLayout.setRefreshing(false);
            return;
        }
        sendRequest();
    }

    // Seng Request GET
    private void sendRequest() {

        showpDialog();

        JsonArrayRequest hotelRequest = new JsonArrayRequest(AppConfig.URL_HOTEL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());

                        // clear movie in movies array for update and add new movie
                        hotelList.clear();

                        try {
                            // Parsing json array response
                            // loop through each json object
                            for (int i = 0; i < response.length(); i++) {

                                JSONObject obj = response.getJSONObject(i);
                                Hotel hotel = new Hotel();
                                hotel.setIdtenant(obj.getInt("idtenant"));
                                hotel.setAvatar(obj.getString("avatar"));
                                hotel.setName(obj.getString("name"));
                                hotel.setAddress(obj.getString("address"));
                                hotel.setPhone(obj.getString("phone"));

                                // adding movie to movies array

                                hotelList.add(hotel);

                            }
                            //contentManager.saveHotel(HotelActivity.this, hotelList);

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(),
                                    "Error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                        mSwipeRefreshLayout.setRefreshing(false);
                        hidepDialog();
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
                mSwipeRefreshLayout.setRefreshing(false);
                hidepDialog();

            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(hotelRequest);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

}