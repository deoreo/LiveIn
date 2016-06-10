package com.example.profile.Activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.style.URLSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.profile.R;

public class InvitationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invitation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void share(View view) {
        Toast.makeText(InvitationActivity.this, "you clicked share", Toast.LENGTH_SHORT).show();
    }

    public void twitt(View view) {
        Toast.makeText(InvitationActivity.this, "you clicked twitt", Toast.LENGTH_SHORT).show();
    }

    public void text(View view) {
        Toast.makeText(InvitationActivity.this, "you clicked text", Toast.LENGTH_SHORT).show();
    }

    public void email(View view) {
        Toast.makeText(InvitationActivity.this, "you clicked email", Toast.LENGTH_SHORT).show();
    }


    public void lippo(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.lippocikarang.com"));
        startActivity(browserIntent);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == android.R.id.home) {
            InvitationActivity.this.onBackPressed();

        }


        return super.onOptionsItemSelected(item);
    }


}
