package com.example.content.Activity;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.content.R;

/**
 * Created by M. Asrof Bayhaqqi on 6/7/2016.
 */
public class Home extends AppCompatActivity {

    Animation fade_in, fade_out;
    ViewFlipper viewFlipper;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar bar;
    Button btn_entertaiment, btn_dining, btn_accomodation, btn_shopping, btn_transportation, btn_gallery, btn_call_tbd, btn_discount_coupon;
    ImageButton btn_youtube, btn_instagram;
    LinearLayout linearLayout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        bar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(bar);

        getSupportActionBar().setTitle("Home");

        initSlider();
        initView();

        btn_entertaiment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Snackbar.make(linearLayout, "Entertaiment", Snackbar.LENGTH_LONG).show();*/
                Intent intent_entertaiment = new Intent(Home.this, Entertaiment.class);
                startActivity(intent_entertaiment);
                Home.this.finish();
            }
        });
        btn_dining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Snackbar.make(linearLayout, "Dining", Snackbar.LENGTH_LONG).show();*/
                Intent intent_entertaiment1 = new Intent(Home.this, Dining.class);
                startActivity(intent_entertaiment1);
                Home.this.finish();
            }
        });
        btn_accomodation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Snackbar.make(linearLayout, "Accomodation", Snackbar.LENGTH_LONG).show();*/
                Intent intent_accomodation= new Intent(Home.this, Accomodation.class);
                startActivity(intent_accomodation);
                Home.this.finish();
            }
        });
        btn_shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Snackbar.make(linearLayout, "Shopping", Snackbar.LENGTH_LONG).show();*/
                Intent intent_shopping = new Intent(Home.this, Shopping.class);
                startActivity(intent_shopping);
                Home.this.finish();
            }
        });
        btn_transportation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Snackbar.make(linearLayout, "Transportation", Snackbar.LENGTH_LONG).show();*/
                Intent intent_entertaiment = new Intent(Home.this, Transportation.class);
                startActivity(intent_entertaiment);
                Home.this.finish();
            }
        });
        btn_gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(linearLayout, "Gallery", Snackbar.LENGTH_LONG).show();
            }
        });
        btn_call_tbd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(linearLayout, "Call (TBD)", Snackbar.LENGTH_LONG).show();
            }
        });
        btn_discount_coupon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(linearLayout, "Discount Coupon", Snackbar.LENGTH_LONG).show();
            }
        });
        btn_youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(linearLayout, "Youtube", Snackbar.LENGTH_LONG).show();
            }
        });
        btn_instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(linearLayout, "", Snackbar.LENGTH_LONG).show();
            }
        });



        navigationView = (android.support.design.widget.NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);

                //Closing drawer on item click
                drawerLayout.closeDrawers();

                //Check to see which item was being clicked and perform appropriate action
                int i = menuItem.getItemId();
                if (i == R.id.about_us) {/*Toast.makeText(getApplicationContext(), "About Us", Toast.LENGTH_SHORT).show();*/
                    Intent intent_about_us = new Intent(Home.this, AboutUs.class);
                    startActivity(intent_about_us);
                    Home.this.finish();
                    return true;
                } else if (i == R.id.getting_to_know) {/*Toast.makeText(getApplicationContext(), "Getting to Know", Toast.LENGTH_SHORT).show();*/
                    Intent intent_news = new Intent(Home.this, GettingToKnow.class);
                    startActivity(intent_news);
                    Home.this.finish();
                    return true;
                } else if (i == R.id.entertainment) {/*Toast.makeText(getApplicationContext(), "Entertaiment", Toast.LENGTH_SHORT).show();*/
                    Intent intent_entertaiment = new Intent(Home.this, Entertaiment.class);
                    startActivity(intent_entertaiment);
                    Home.this.finish();
                    return true;
                } else if (i == R.id.dining) {
                    /*Toast.makeText(getApplicationContext(), "Dining", Toast.LENGTH_SHORT).show();*/
                    Intent intent_dining = new Intent(Home.this, Dining.class);
                    startActivity(intent_dining);
                    Home.this.finish();
                    return true;
                } else if (i == R.id.accomodation) {
                    /*Toast.makeText(getApplicationContext(), "Accomodation", Toast.LENGTH_SHORT).show();*/
                    Intent intent_accomodation= new Intent(Home.this, Accomodation.class);
                    startActivity(intent_accomodation);
                    Home.this.finish();
                    return true;
                } else if (i == R.id.shopping) {
                    /*Toast.makeText(getApplicationContext(), "Shopping", Toast.LENGTH_SHORT).show();*/
                    Intent intent_shopping = new Intent(Home.this, Shopping.class);
                    startActivity(intent_shopping);
                    Home.this.finish();
                    return true;
                } else if (i == R.id.education) {/* Toast.makeText(getApplicationContext(), "Education", Toast.LENGTH_SHORT).show();*/
                    Intent intent_education = new Intent(Home.this, Education.class);
                    startActivity(intent_education);
                    Home.this.finish();
                    return true;
                } else if (i == R.id.health_care) {/*Toast.makeText(getApplicationContext(), "Health Care", Toast.LENGTH_SHORT).show();*/
                    Intent intent_health_care = new Intent(Home.this, HealthCare.class);
                    startActivity(intent_health_care);
                    Home.this.finish();
                    return true;
                } else if (i == R.id.transportation) {/*Toast.makeText(getApplicationContext(), "Transportation", Toast.LENGTH_SHORT).show();*/
                    Intent intent_transportation = new Intent(Home.this, Transportation.class);
                    startActivity(intent_transportation);
                    Home.this.finish();
                    return true;
                } else if (i == R.id.public_services) {/*Toast.makeText(getApplicationContext(), " Public Services", Toast.LENGTH_SHORT).show();*/
                    Intent intent_public_services = new Intent(Home.this, PublicServices.class);
                    startActivity(intent_public_services);
                    Home.this.finish();
                    return true;
                } else if (i == R.id.industrial_directory) {/*Toast.makeText(getApplicationContext(), "Industrial Directory", Toast.LENGTH_SHORT).show();*/
                    Intent intent_industrial_directory = new Intent(Home.this, Industry.class);
                    startActivity(intent_industrial_directory);
                    Home.this.finish();
                    return true;
                } else if (i == R.id.photo_gallery) {
                    Toast.makeText(getApplicationContext(), "Photo Gallery", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (i == R.id.help) {
                    Toast.makeText(getApplicationContext(), "Help", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (i == R.id.useful_information) {
                    Toast.makeText(getApplicationContext(), "Useful Information", Toast.LENGTH_SHORT).show();
                    return true;
                } else {
                    Toast.makeText(getApplicationContext(), "Somethings Wrong", Toast.LENGTH_SHORT).show();
                    return true;
                }
            }
        });

        // Initializing Drawer Layout and ActionBarToggle
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, bar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state
        actionBarDrawerToggle.syncState();
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

        btn_entertaiment = (Button) findViewById(R.id.btn_entertaiment);
        btn_dining = (Button) findViewById(R.id.btn_dining);
        btn_accomodation = (Button) findViewById(R.id.btn_accomodation);
        btn_shopping = (Button) findViewById(R.id.btn_shopping);
        btn_transportation = (Button) findViewById(R.id.btn_transportation);
        btn_gallery = (Button) findViewById(R.id.btn_gallery);
        btn_call_tbd = (Button) findViewById(R.id.btn_call_tbd);
        btn_discount_coupon = (Button) findViewById(R.id.btn_discount_coupon);

        btn_youtube = (ImageButton) findViewById(R.id.btn_youtube);
        btn_instagram = (ImageButton) findViewById(R.id.btn_instagram);
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
        } else if (id == R.id.home) {
            this.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
