package com.example.profile.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.profile.Adapter.Custom_list;
import com.example.profile.R;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ProfileActivity extends AppCompatActivity {

    ListView list;
    RelativeLayout relativeLayout;
    String[] web = {
            "My Notification",
            "My History",
            "Edit Profile",
            "Bookmark",
            "Invite Friend",
            "SignOut",
    };
    Integer[] imageId = {
            R.drawable.info,
            R.drawable.clock,
            R.drawable.pencil,
            R.drawable.map,
            R.drawable.group,
            R.drawable.power, 7
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_screen);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativelayout);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Custom_list adapter = new
                Custom_list(ProfileActivity.this, web, imageId);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent i = null;
                if (position == 0) {
                    Snackbar.make(relativeLayout, "My Notification", Snackbar.LENGTH_LONG).show();

                } else if (position == 1) {
                    Snackbar.make(relativeLayout, "My History", Snackbar.LENGTH_LONG).show();

                } else if (position == 2) {
                    i = new Intent(ProfileActivity.this, EditProfileActivity.class);
                    startActivity(i);
                } else if (position == 3) {
                    Snackbar.make(relativeLayout, "Bookmark", Snackbar.LENGTH_LONG).show();

                } else if (position == 4) {
                    i = new Intent(ProfileActivity.this, InvitationActivity.class);
                    startActivity(i);
                } else if (position == 5) {
                    Snackbar.make(relativeLayout, "Sign out", Snackbar.LENGTH_LONG).show();
                }


            }
        });


    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

}

