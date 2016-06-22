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
 * Created by M. Asrof Bayhaqqi on 6/9/2016.
 */
public class Entertaiment extends AppCompatActivity {

    Animation fade_in, fade_out;
    ViewFlipper viewFlipper;
    Toolbar bar;
    Button btn_recommended, btn_events, btn_sport, btn_leisure, btn_art_and_culture, btn_beauty, btn_others;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entertaiment);

        bar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(bar);

        getSupportActionBar().setTitle("Entertaiment");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        initSlider();
        initView();

        btn_recommended.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Snackbar.make(linearLayout, "Recommended", Snackbar.LENGTH_LONG).show();*/
                Intent intent_entertaiment = new Intent(Entertaiment.this, EntertaimentRecommended.class);
                startActivity(intent_entertaiment);
            }
        });
        btn_events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Snackbar.make(linearLayout, "Events", Snackbar.LENGTH_LONG).show();*/
                Intent intent_events = new Intent(Entertaiment.this, EntertaimentEvents.class);
                startActivity(intent_events);
            }
        });
        btn_sport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Snackbar.make(linearLayout, "Sport", Snackbar.LENGTH_LONG).show();*/
                Intent intent_sport= new Intent(Entertaiment.this, EntertaimentSport.class);
                startActivity(intent_sport);
            }
        });
        btn_leisure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Snackbar.make(linearLayout, "Leisure", Snackbar.LENGTH_LONG).show();*/
                Intent intent_leisure= new Intent(Entertaiment.this, EntertaimentLeisure.class);
                startActivity(intent_leisure);
            }
        });
        btn_art_and_culture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Snackbar.make(linearLayout, "Art & Culture", Snackbar.LENGTH_LONG).show();*/
                Intent intent_art= new Intent(Entertaiment.this, EntertaimentArt.class);
                startActivity(intent_art);
            }
        });
        btn_beauty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Snackbar.make(linearLayout, "Beauty", Snackbar.LENGTH_LONG).show();*/
                Intent intent_beauty= new Intent(Entertaiment.this, EntertaimentBeauty.class);
                startActivity(intent_beauty);
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
        btn_events = (Button) findViewById(R.id.btn_events);
        btn_sport = (Button) findViewById(R.id.btn_sport);
        btn_leisure = (Button) findViewById(R.id.btn_leisure);
        btn_art_and_culture = (Button) findViewById(R.id.btn_art_and_culture);
        btn_beauty = (Button) findViewById(R.id.btn_beauty);
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
            Toast.makeText(getApplicationContext(), "MapDetail", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.download) {
            Toast.makeText(getApplicationContext(), "Download", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == android.R.id.home) {
            Intent intent_entertaiment = new Intent(Entertaiment.this, Home.class);
            startActivity(intent_entertaiment);
            Entertaiment.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent_entertaiment = new Intent(Entertaiment.this, Home.class);
        startActivity(intent_entertaiment);
        Entertaiment.this.finish();
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
