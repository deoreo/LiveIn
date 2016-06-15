package com.example.content.Activity;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.content.Adapter.EntertaimetBeautyAdapter;
import com.example.content.Model.SubCategoryItem;
import com.example.content.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SMK Telkom SP Malang on 10/06/2016.
 */
public class EntertaimentBeauty extends AppCompatActivity implements
        AdapterView.OnItemClickListener {

    Spinner spinner;
    String[] cities = {
            "Mumbai",
            "Delhi",
            "Bangalore",
            "Hyderabad",
            "Ahmedabad",
            "Chennai",
            "Kolkata",
            "Pune",
            "Jabalpur"
    };
    public static final String[] title = new String[]{"Strawberry",
            "Banana", "Orange", "Mixed"};

    public static final String[] location = new String[]{
            "It is an aggregate accessory fruit",
            "It is the largest herbaceous flowering plant", "Citrus Fruit",
            "Mixed Fruits"};

    public static final String[] distance = new String[]{
            "It is an aggregate accessory fruit",
            "It is the largest herbaceous flowering plant", "Citrus Fruit",
            "Mixed Fruits"};

    public static final Integer[] thumbnail = {R.drawable.profile_pc,
            R.drawable.profile_pc, R.drawable.profile_pc, R.drawable.profile_pc};

    ListView listView;
    List<com.example.content.Model.SubCategoryItem> SubCategoryItem;

    /**
     * Called when the activity is first cr eated.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub_category);

        Toolbar bar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(bar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Health Care");


/*        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> apt =new ArrayAdapter<String>(this,R.layout.spinner_items,cities);
        spinner.setAdapter(apt);
        spinner.setPrompt("Category");

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int sid=spinner.getSelectedItemPosition();
                Toast.makeText(getBaseContext(), "You have selected City : " + cities[sid],
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/


        SubCategoryItem = new ArrayList<com.example.content.Model.SubCategoryItem>();
        for (int i = 0; i < title.length; i++) {
            com.example.content.Model.SubCategoryItem item = new SubCategoryItem(thumbnail[i], title[i], location[i], distance[i]);
            SubCategoryItem.add(item);
        }

        listView = (ListView) findViewById(R.id.list_view);
        EntertaimetBeautyAdapter adapter = new EntertaimetBeautyAdapter(this,
                R.layout.sub_category_item, SubCategoryItem);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
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
                Intent intent_beauty0 = new Intent(getApplicationContext(), EntertaimentBeautyDetail.class);
                startActivity(intent_beauty0);
                break;
            case 1:
                /*Snackbar.make(listView, "Position : " + getPosition(), Snackbar.LENGTH_LONG).show();*/
                Intent intent_beauty1 = new Intent(getApplicationContext(), EntertaimentBeautyDetail.class);
                startActivity(intent_beauty1);
                break;
            case 2:
               /*Snackbar.make(listView, "Position : " + getPosition(), Snackbar.LENGTH_LONG).show();*/
                Intent intent_beauty2 = new Intent(getApplicationContext(), EntertaimentBeautyDetail.class);
                startActivity(intent_beauty2);
                break;
            case 3:
               /*Snackbar.make(listView, "Position : " + getPosition(), Snackbar.LENGTH_LONG).show();*/
                Intent intent_beauty3 = new Intent(getApplicationContext(), EntertaimentBeautyDetail.class);
                startActivity(intent_beauty3);
                break;
            case 4:
               /*Snackbar.make(listView, "Position : " + getPosition(), Snackbar.LENGTH_LONG).show();*/
                Intent intent_beauty4 = new Intent(getApplicationContext(), EntertaimentBeautyDetail.class);
                startActivity(intent_beauty4);
                break;
            case 5:
               /*Snackbar.make(listView, "Position : " + getPosition(), Snackbar.LENGTH_LONG).show();*/
                Intent intent_beauty5 = new Intent(getApplicationContext(), EntertaimentBeautyDetail.class);
                startActivity(intent_beauty5);
                break;
            case 6:
               /*Snackbar.make(listView, "Position : " + getPosition(), Snackbar.LENGTH_LONG).show();*/
                Intent intent_beauty6 = new Intent(getApplicationContext(), EntertaimentBeautyDetail.class);
                startActivity(intent_beauty6);
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
}