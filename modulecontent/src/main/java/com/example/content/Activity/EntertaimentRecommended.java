package com.example.content.Activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.example.content.Adapter.EntertaimentRecommendedAdapter;
import com.example.content.Controller.AppConfig;
import com.example.content.Controller.AppController;
import com.example.content.Model.RecommendedModel;
import com.example.content.R;
import com.example.content.Util.ConnUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by M. Asrof Bayhaqqi on 6/8/2016.
 */
public class EntertaimentRecommended extends AppCompatActivity {

    // Log tag
    private static final String TAG = EntertaimentRecommended.class.getSimpleName();

    private List<RecommendedModel> listRecomendedItem;

    Toolbar bar;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    Spinner spinner_category, spinner_sort;
    private LinearLayout linearLayout;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recommended_new);

        bar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(bar);

        getSupportActionBar().setTitle("Entertaiment Recommended");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        initView();
        initSwipeRefresh();
        initRecyclerView();
        initSpinner();
        downData();
    }

    // Initialization view
    private void initView() {
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
    }

    // Initialization Recycler view
    private void initRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        mRecyclerView.setHasFixedSize(true);
        listRecomendedItem = new ArrayList<>();

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new EntertaimentRecommendedAdapter(listRecomendedItem,this);
        mRecyclerView.setAdapter(mAdapter);
    }

    // Initialization spinner
    private void initSpinner() {
        spinner_category = (Spinner) findViewById(R.id.spinner_category);
        spinner_category.setVisibility(View.INVISIBLE);
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
        mSwipeRefreshLayout.setRefreshing(false);
    }

    // Seng Request GET
    private void sendRequest() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, AppConfig.URL_RECOMMENDED+"14",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, response.toString());

                        // clear art in art array for update and add new art
                        listRecomendedItem.clear();

                        try {
                            JSONArray jArray = new JSONArray(response);

                            for (int i = 0; i < jArray.length(); i++) {

                                JSONObject object = jArray.getJSONObject(i);
                                RecommendedModel recommendedItem = new RecommendedModel();
                                recommendedItem.setAvatar(object.getString("avatar"));
                                recommendedItem.setName(object.getString("nama_tenant"));
                                recommendedItem.setAddress(object.getString("address"));
                                listRecomendedItem.add(i,recommendedItem);
                                mAdapter.notifyDataSetChanged();

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(),
                                    "Error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        AppController.getInstance().addToRequestQueue(stringRequest);
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
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
        } else if (id == R.id.profile){
            Toast.makeText(getApplicationContext(), "Profile", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.map) {
            Toast.makeText(getApplicationContext(), "Map", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.download){
            Toast.makeText(getApplicationContext(), "Download", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == android.R.id.home){
            this.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

}