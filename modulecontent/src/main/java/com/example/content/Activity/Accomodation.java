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
public class Accomodation extends AppCompatActivity {

    Animation fade_in, fade_out;
    ViewFlipper viewFlipper;
    Toolbar bar;
    Button btn_recommended, btn_condominiums, btn_hotel, btn_apartment;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accomodation);

        bar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(bar);

        getSupportActionBar().setTitle("Accomodation");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        initSlider();
        initView();

        btn_recommended.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Snackbar.make(linearLayout, "Recommended", Snackbar.LENGTH_LONG).show();*/
                Intent intent_recommendedn = new Intent(Accomodation.this, AccomodationRecommended.class);
                startActivity(intent_recommendedn);
            }
        });
        btn_condominiums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Snackbar.make(linearLayout, "Condominiums", Snackbar.LENGTH_LONG).show();*/
                Intent intent_condominiums= new Intent(Accomodation.this, AccomodationCondominiums.class);
                startActivity(intent_condominiums);
            }
        });
        btn_hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Snackbar.make(linearLayout, "Hotel", Snackbar.LENGTH_LONG).show();*/
                Intent intent_hotel= new Intent(Accomodation.this, AccomodationHotel.class);
                startActivity(intent_hotel);
            }
        });
        btn_apartment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Snackbar.make(linearLayout, "Apartment", Snackbar.LENGTH_LONG).show();*/
                Intent intent_apartment= new Intent(Accomodation.this, AccomodationApartment.class);
                startActivity(intent_apartment);
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
        btn_condominiums = (Button) findViewById(R.id.btn_condominiums);
        btn_hotel = (Button) findViewById(R.id.btn_hotel);
        btn_apartment = (Button) findViewById(R.id.btn_apartment);
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
            Intent intent_accomodation = new Intent(Accomodation.this, Home.class);
            startActivity(intent_accomodation);
            Accomodation.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent_accomodation = new Intent(Accomodation.this, Home.class);
        startActivity(intent_accomodation);
        Accomodation.this.finish();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
