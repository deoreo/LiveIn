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
 * Created by SMK Telkom SP Malang on 09/06/2016.
 */
public class PublicServices extends AppCompatActivity {

    Animation fade_in, fade_out;
    ViewFlipper viewFlipper;
    Toolbar bar;
    Button btn_tour_travel, btn_property_agents, btn_spbu, btn_notaris, btn_atm_gallery, btn_bank, btn_insurance,btn_workshop,btn_others;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.public_services);

        bar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(bar);

        getSupportActionBar().setTitle("Public Services");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        initSlider();
        initView();

        btn_tour_travel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Snackbar.make(linearLayout, "Tour & Travel", Snackbar.LENGTH_LONG).show();*/
                Intent intent_tour_travel= new Intent(PublicServices.this, PublicServicesTour.class);
                startActivity(intent_tour_travel);
            }
        });
        btn_property_agents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Snackbar.make(linearLayout, "Property Agents", Snackbar.LENGTH_LONG).show();*/
                Intent intent_property_agents= new Intent(PublicServices.this, PublicServicesPropertyAgents.class);
                startActivity(intent_property_agents);
            }
        });
        btn_spbu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Snackbar.make(linearLayout, "SPBU", Snackbar.LENGTH_LONG).show();*/
                Intent intent_spbu= new Intent(PublicServices.this, PublicServicesSPBU.class);
                startActivity(intent_spbu);
            }
        });
        btn_notaris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Snackbar.make(linearLayout, "Notaris", Snackbar.LENGTH_LONG).show();*/
                Intent intent_notaris= new Intent(PublicServices.this, PublicServicesNotaris.class);
                startActivity(intent_notaris);
            }
        });
        btn_atm_gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Snackbar.make(linearLayout, "ATM Gallery", Snackbar.LENGTH_LONG).show();*/
                Intent intent_atm_gallery= new Intent(PublicServices.this, PublicServicesATM.class);
                startActivity(intent_atm_gallery);
            }
        });
        btn_bank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Snackbar.make(linearLayout, "Bank", Snackbar.LENGTH_LONG).show();*/
                Intent intent_bank= new Intent(PublicServices.this, PublicServicesBank.class);
                startActivity(intent_bank);
            }
        });
        btn_insurance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Snackbar.make(linearLayout, "Insurance", Snackbar.LENGTH_LONG).show();*/
                Intent intent_insurance= new Intent(PublicServices.this, PublicServicesInsurance.class);
                startActivity(intent_insurance);
            }
        });
        btn_workshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Snackbar.make(linearLayout, "Workshop", Snackbar.LENGTH_LONG).show();*/
                Intent intent_workshop= new Intent(PublicServices.this, PublicServicesWorkshop.class);
                startActivity(intent_workshop);
            }
        });
        btn_others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(linearLayout, "Others", Snackbar.LENGTH_LONG).show();
                /*Intent intent_others= new Intent(PublicServices.this, PublicServicesOthers.class);
                startActivity(intent_others);*/
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

        btn_tour_travel = (Button) findViewById(R.id.btn_tour_travel);
        btn_property_agents = (Button) findViewById(R.id.btn_property_agents);
        btn_spbu = (Button) findViewById(R.id.btn_spbu);
        btn_notaris = (Button) findViewById(R.id.btn_notaris);
        btn_atm_gallery = (Button) findViewById(R.id.btn_atm_gallery);
        btn_bank = (Button) findViewById(R.id.btn_bank);
        btn_insurance = (Button) findViewById(R.id.btn_insurance);
        btn_workshop=(Button) findViewById(R.id.btn_workshop);
        btn_others=(Button)findViewById(R.id.btn_others);
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
            Intent intent_public_services = new Intent(PublicServices.this, Home.class);
            startActivity(intent_public_services);
            PublicServices.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent_public_services = new Intent(PublicServices.this, Home.class);
        startActivity(intent_public_services);
        PublicServices.this.finish();;
    }
}
