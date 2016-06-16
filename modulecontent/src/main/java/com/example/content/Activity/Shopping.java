package com.example.content.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.content.R;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by Administrator on 10/06/2016.
 */
public class Shopping extends AppCompatActivity {

    Animation fade_in, fade_out;
    ViewFlipper viewFlipper;
    Toolbar bar;
    Button btn_recommended, btn_department_store, btn_mart, btn_home_improvement, btn_fashion, btn_book_and_stationety, btn_electronic, btn_automotive, btn_others;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping);

        bar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(bar);

        getSupportActionBar().setTitle("Shopping");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        initSlider();
        initView();

        btn_recommended.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Snackbar.make(linearLayout, "Recommended", Snackbar.LENGTH_LONG).show();*/
                Intent intent_recommended = new Intent(Shopping.this, ShoppingRecommended.class);
                startActivity(intent_recommended);
            }
        });
        btn_department_store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Snackbar.make(linearLayout, "Department Store", Snackbar.LENGTH_LONG).show();*/
                Intent intent_department_store = new Intent(Shopping.this, ShoppingDepartmentStore.class);
                startActivity(intent_department_store);
            }
        });
        btn_mart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Snackbar.make(linearLayout, "Mart", Snackbar.LENGTH_LONG).show();*/
                Intent intent_mart = new Intent(Shopping.this, ShoppingMart.class);
                startActivity(intent_mart);
            }
        });
        btn_home_improvement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Snackbar.make(linearLayout, "Home Improvement", Snackbar.LENGTH_LONG).show();*/
                Intent intent_home_improvement = new Intent(Shopping.this, ShoppingHomeImprovement.class);
                startActivity(intent_home_improvement);
            }
        });
        btn_fashion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Snackbar.make(linearLayout, "fashion", Snackbar.LENGTH_LONG).show();*/
                Intent intent_fashion= new Intent(Shopping.this, ShoppingFashion.class);
                startActivity(intent_fashion);
            }
        });
        btn_book_and_stationety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Snackbar.make(linearLayout, "Book And Stationety", Snackbar.LENGTH_LONG).show();*/
                Intent intent_book_and_stationery= new Intent(Shopping.this, ShoppingBookAndStationety.class);
                startActivity(intent_book_and_stationery);
            }
        });
        btn_electronic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Snackbar.make(linearLayout, "Electronic", Snackbar.LENGTH_LONG).show();*/
                Intent intent_electronic= new Intent(Shopping.this, ShoppingElectronic.class);
                startActivity(intent_electronic);
            }
        });
        btn_automotive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Snackbar.make(linearLayout, "Automotive", Snackbar.LENGTH_LONG).show();*/
                Intent intent_automotive= new Intent(Shopping.this, ShoppingAutomotive.class);
                startActivity(intent_automotive);
            }
        });
        btn_others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(linearLayout, "Others", Snackbar.LENGTH_LONG).show();
            }
        });
    }

    private void initSlider() {
        viewFlipper = (ViewFlipper) this.findViewById(R.id.bckgrndViewFlipper1);
        fade_in = AnimationUtils.loadAnimation(this,
                android.R.anim.fade_in);
        fade_out = AnimationUtils.loadAnimation(this,
                android.R.anim.fade_out);
        viewFlipper.setInAnimation(fade_in);
        viewFlipper.setOutAnimation(fade_out);
        //sets auto flipping
        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(5000);
        viewFlipper.startFlipping();
    }

    private void initView() {
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);

        btn_recommended = (Button) findViewById(R.id.btn_recommended);
        btn_department_store = (Button) findViewById(R.id.btn_department_store);
        btn_mart = (Button) findViewById(R.id.btn_mart);
        btn_home_improvement = (Button) findViewById(R.id.btn_home_improvement);
        btn_fashion = (Button) findViewById(R.id.btn_fashion);
        btn_book_and_stationety = (Button) findViewById(R.id.btn_book_and_stationety);
        btn_electronic = (Button) findViewById(R.id.btn_electronic);
        btn_automotive = (Button) findViewById(R.id.btn_automotive);
        btn_others = (Button) findViewById(R.id.btn_others);
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
            Intent intent_about_us = new Intent(Shopping.this, Home.class);
            startActivity(intent_about_us);
            Shopping.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed() {
        super.onBackPressed();
        Intent intent_entertaiment = new Intent(Shopping.this, Home.class);
        startActivity(intent_entertaiment);
        this.finish();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}

