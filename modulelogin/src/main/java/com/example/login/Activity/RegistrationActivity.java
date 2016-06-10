package com.example.login.Activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.login.R;

public class RegistrationActivity extends AppCompatActivity {

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        //menghubungkan view dengan variabel spinner
        spinner=(Spinner) findViewById(R.id.spinner1);
        //event ketika ada item pada spinner yang dipilih
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            //ketika memilih salah satu item
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                //ambil nilai dari item spinner yang dipilih lalu disimpan pada variabel jk
                String jk=String.valueOf(parentView.getSelectedItem());
                //Menampilkan variabel JK dalam bentuk toast
                Toast.makeText(getApplicationContext(), "Jenis Kelamin Anda "+jk, Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });
    }
}
