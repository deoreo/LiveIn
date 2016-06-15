package com.example.content.Activity;

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

/**
 * Created by SMK Telkom SP Malang on 10/06/2016.
 */
public class Dining extends AppCompatActivity {

    Animation fade_in, fade_out;
    ViewFlipper viewFlipper;
    Toolbar bar;
    Button btn_recommended, btn_japanese, btn_western, btn_bar, btn_fast_food, btn_korean, btn_tradisional, btn_bakery, btn_others;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dining);

        bar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(bar);

        getSupportActionBar().setTitle("Dining");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        initSlider();
        initView();

        btn_recommended.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Snackbar.make(linearLayout, "Recommended", Snackbar.LENGTH_LONG).show();*/
                Intent intent_recommended = new Intent(Dining.this, DiningRecommended.class);
                startActivity(intent_recommended);
            }
        });
        btn_japanese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Snackbar.make(linearLayout, "Japanese", Snackbar.LENGTH_LONG).show();*/
                Intent intent_japanese = new Intent(Dining.this, DiningJapanese.class);
                startActivity(intent_japanese);
            }
        });
        btn_western.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Snackbar.make(linearLayout, "Western", Snackbar.LENGTH_LONG).show();*/
                Intent intent_western = new Intent(Dining.this, DiningWestern.class);
                startActivity(intent_western);
            }
        });
        btn_bar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Snackbar.make(linearLayout, "Bar", Snackbar.LENGTH_LONG).show();*/
                Intent intent_bar= new Intent(Dining.this, DiningBar.class);
                startActivity(intent_bar);
            }
        });
        btn_fast_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Snackbar.make(linearLayout, "Fast Food", Snackbar.LENGTH_LONG).show();*/
                Intent intent_fast = new Intent(Dining.this, DiningFast.class);
                startActivity(intent_fast);
            }
        });
        btn_korean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Snackbar.make(linearLayout, "Korean", Snackbar.LENGTH_LONG).show();*/
                Intent intent_korean = new Intent(Dining.this, DiningKorean.class);
                startActivity(intent_korean);
            }
        });
        btn_tradisional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Snackbar.make(linearLayout, "Traditional", Snackbar.LENGTH_LONG).show();*/
                Intent intent_tradisiona = new Intent(Dining.this, DiningTraditional.class);
                startActivity(intent_tradisiona);
            }
        });
        btn_bakery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Snackbar.make(linearLayout, "Bakery", Snackbar.LENGTH_LONG).show();*/
                Intent intent_bakery = new Intent(Dining.this, DiningBakery.class);
                startActivity(intent_bakery);
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
        btn_japanese = (Button) findViewById(R.id.btn_japanese);
        btn_western = (Button) findViewById(R.id.btn_western);
        btn_bar = (Button) findViewById(R.id.btn_bar);
        btn_fast_food = (Button) findViewById(R.id.btn_fast_food);
        btn_korean=(Button)findViewById(R.id.btn_korean);
        btn_tradisional = (Button) findViewById(R.id.btn_tradisional);
        btn_bakery = (Button) findViewById(R.id.btn_bakery);
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
            Intent intent_dining = new Intent(Dining.this, Home.class);
            startActivity(intent_dining);
            Dining.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent_dining = new Intent(Dining.this, Home.class);
        startActivity(intent_dining);
        Dining.this.finish();
    }
}
