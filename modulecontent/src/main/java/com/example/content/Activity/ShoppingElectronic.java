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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.example.content.Adapter.ShoppingElectronicAdapter;
import com.example.content.Model.SubCategoryItem;
import com.example.content.R;

/**
 * Created by Administrator on 13/06/2016.
 */
public class ShoppingElectronic extends AppCompatActivity implements
        AdapterView.OnItemClickListener {

    public static final String[] title = new String[]{
            "ShoppingElectronic 1", "ShoppingElectronic 2", "ShoppingElectronic 3", "ShoppingElectronic 4", "ShoppingElectronic 5", "ShoppingElectronic 6", "ShoppingElectronic 7"};

    public static final String[] location = new String[]{
            "Location ShoppingElectronic 1",
            "Location ShoppingElectronic 2",
            "Location FElectronic 3",
            "Location ShoppingElectronic 4",
            "Location ShoppingElectronic 5",
            "Location ShoppingElectronic 6",
            "Location ShoppingElectronic 7",};

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

        getSupportActionBar().setTitle("ShoppingElectronic");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


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


        SubCategoryItem = new ArrayList<SubCategoryItem>();
        for (int i = 0; i < title.length; i++) {
            SubCategoryItem item = new SubCategoryItem(thumbnail[i], title[i], location[i], distance[i]);
            SubCategoryItem.add(item);
        }

        listView = (ListView) findViewById(R.id.list_view);
        ShoppingElectronicAdapter adapter = new ShoppingElectronicAdapter(this,
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
                Intent intent_electronic0 = new Intent(getApplicationContext(), ShoppingElectronicDetail.class);
                startActivity(intent_electronic0);
                break;
            case 1:
                /*Snackbar.make(listView, "Position : " + getPosition(), Snackbar.LENGTH_LONG).show();*/
                Intent intent_electronic1 = new Intent(getApplicationContext(), ShoppingElectronicDetail.class);
                startActivity(intent_electronic1);
                break;
            case 2:
               /*Snackbar.make(listView, "Position : " + getPosition(), Snackbar.LENGTH_LONG).show();*/
                Intent intent_electronic2 = new Intent(getApplicationContext(), ShoppingElectronicDetail.class);
                startActivity(intent_electronic2);
                break;
            case 3:
               /*Snackbar.make(listView, "Position : " + getPosition(), Snackbar.LENGTH_LONG).show();*/
                Intent intent_electronic3 = new Intent(getApplicationContext(), ShoppingElectronicDetail.class);
                startActivity(intent_electronic3);
                break;
            case 4:
               /*Snackbar.make(listView, "Position : " + getPosition(), Snackbar.LENGTH_LONG).show();*/
                Intent intent_electronic4 = new Intent(getApplicationContext(), ShoppingElectronicDetail.class);
                startActivity(intent_electronic4);
                break;
            case 5:
               /*Snackbar.make(listView, "Position : " + getPosition(), Snackbar.LENGTH_LONG).show();*/
                Intent intent_electronic5 = new Intent(getApplicationContext(), ShoppingElectronicDetail.class);
                startActivity(intent_electronic5);
                break;
            case 6:
               /*Snackbar.make(listView, "Position : " + getPosition(), Snackbar.LENGTH_LONG).show();*/
                Intent intent_electronic6 = new Intent(getApplicationContext(), ShoppingElectronicDetail.class);
                startActivity(intent_electronic6);
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
