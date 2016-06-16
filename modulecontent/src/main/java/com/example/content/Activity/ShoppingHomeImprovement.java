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

import java.util.ArrayList;
import java.util.List;

import com.example.content.Adapter.ShoppingHomeImprovementAdapter;
import com.example.content.Model.SubCategoryItem;
import com.example.content.R;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by Administrator on 13/06/2016.
 */
public class ShoppingHomeImprovement extends AppCompatActivity implements
        AdapterView.OnItemClickListener {

    Spinner spinner_category, spinner_sort;
    public static final String[] title = new String[]{
            "Home Improvement 1", "Home Improvement 2", "Home Improvement 3", "Home Improvement 4", "Home Improvement 5",
            "Home Improvement 6", "Home Improvement 7"};

    public static final String[] location = new String[]{
            "Location Home Improvement 1",
            "Location Home Improvement 2",
            "Location Home Improvement 3",
            "Location Home Improvement 4",
            "Location Home Improvement 5",
            "Location Home Improvement 6",
            "Location Home Improvement 7",};

    public static final String[] distance = new String[]{
            "1 KM",
            "2 KM",
            "3 KM",
            "4 KM",
            "5 KM",
            "6 KM",
            "7 KM",};

    public static final Integer[] thumbnail = {
            R.drawable.profile_pc,
            R.drawable.profile_pc,
            R.drawable.profile_pc,
            R.drawable.profile_pc,
            R.drawable.profile_pc,
            R.drawable.profile_pc,
            R.drawable.profile_pc};

    ListView listView;
    List<SubCategoryItem> SubCategoryItem;

    /**
     * Called when the activity is first cr eated.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub_category);

        Toolbar bar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(bar);

        getSupportActionBar().setTitle("Home Improvement");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        SubCategoryItem = new ArrayList<SubCategoryItem>();
        for (int i = 0; i < title.length; i++) {
            SubCategoryItem item = new SubCategoryItem(thumbnail[i], title[i], location[i], distance[i]);
            SubCategoryItem.add(item);
        }

        listView = (ListView) findViewById(R.id.list_view);
        ShoppingHomeImprovementAdapter adapter = new ShoppingHomeImprovementAdapter(this,
                R.layout.sub_category_item, SubCategoryItem);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        initSpinner();
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
                Intent intent_home_improvement0 = new Intent(getApplicationContext(), ShoppingHomeImprovementDetail.class);
                startActivity(intent_home_improvement0);
                break;
            case 1:
                /*Snackbar.make(listView, "Position : " + getPosition(), Snackbar.LENGTH_LONG).show();*/
                Intent intent_home_improvement1 = new Intent(getApplicationContext(), ShoppingHomeImprovementDetail.class);
                startActivity(intent_home_improvement1);
                break;
            case 2:
               /*Snackbar.make(listView, "Position : " + getPosition(), Snackbar.LENGTH_LONG).show();*/
                Intent intent_home_improvement2 = new Intent(getApplicationContext(), ShoppingHomeImprovementDetail.class);
                startActivity(intent_home_improvement2);
                break;
            case 3:
               /*Snackbar.make(listView, "Position : " + getPosition(), Snackbar.LENGTH_LONG).show();*/
                Intent intent_home_improvement3 = new Intent(getApplicationContext(), ShoppingHomeImprovementDetail.class);
                startActivity(intent_home_improvement3);
                break;
            case 4:
               /*Snackbar.make(listView, "Position : " + getPosition(), Snackbar.LENGTH_LONG).show();*/
                Intent intent_home_improvement4 = new Intent(getApplicationContext(), ShoppingHomeImprovementDetail.class);
                startActivity(intent_home_improvement4);
                break;
            case 5:
               /*Snackbar.make(listView, "Position : " + getPosition(), Snackbar.LENGTH_LONG).show();*/
                Intent intent_home_improvement5 = new Intent(getApplicationContext(), ShoppingHomeImprovementDetail.class);
                startActivity(intent_home_improvement5);
                break;
            case 6:
               /*Snackbar.make(listView, "Position : " + getPosition(), Snackbar.LENGTH_LONG).show();*/
                Intent intent_home_improvement6 = new Intent(getApplicationContext(), ShoppingHomeImprovementDetail.class);
                startActivity(intent_home_improvement6);
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

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
