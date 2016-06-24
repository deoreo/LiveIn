package com.example.content.Activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.example.content.Controller.AppConfig;
import com.example.content.Controller.AppController;
import com.example.content.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by SMK Telkom SP Malang on 10/06/2016.
 */
public class DiningWesternDetail extends AppCompatActivity {

    Toolbar bar;
    Button btn_map, btn_bookmark, btn_photo;
    TextView txt_name,txt_address,txt_open,txt_close,txt_phone,txt_specialOffer, txt_info;
    ProgressDialog pDialog;
    Double latitude,longitude;
    NetworkImageView imageView;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();
    String get_idTenant, get_name, get_distance;

    public static String[] menu;
    public static String[] harga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub_category_detail);

        bar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(bar);

        getSupportActionBar().setTitle("Western Detail");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        initView();
        initPDialog();
        sendRequest();

        btn_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DiningWesternDetail.this, MapDetail.class);
//                Bundle extras = new Bundle();
//                extras.putString("latitude", latitude);
//                extras.putString("longitude", longitude);
//                intent.putExtras(extras);
                startActivity(intent);
            }
        });
    }
    private void sendRequest() {
        String tag_string_req = "request";
        showpDialog();

        StringRequest strReq = new StringRequest(Request.Method.GET, AppConfig.URL_DETAIL_DINING, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    JSONObject detail = new JSONObject(response);

//                    JSONArray jArray = detail.getJSONArray("detail");
//
//                    for (int i=0; i<jArray.length();i++) {

                    JSONObject object = detail.getJSONObject("detail");

                    String avatar = object.getString("avatar");
                    imageView.setImageUrl(avatar, imageLoader);

                    txt_name.setText(object.getString("name"));
                    txt_address.setText(object.getString("address"));
                    txt_open.setText(object.getString("open"));
                    txt_close.setText(object.getString("close"));
                    txt_phone.setText(object.getString("phone"));
                    txt_specialOffer.setText(object.getString("specialoffer"));

                    JSONArray jArray2 = detail.getJSONArray("menu");
                    Log.d("JSONArray", jArray2.toString());


                    menu = new String[jArray2.length()];
                    harga = new String[jArray2.length()];

                    for (int j = 0; j < jArray2.length(); j++) {

                        JSONObject obj = jArray2.getJSONObject(j);

                        menu[j] = obj.getString("menu");
                        harga[j] = obj.getString("harga");
//                        if(object.getString("info").equals("1")){
//                            txt_info.setText("OPEN");
//                        }else{
//                            txt_info.setText("CLOSE");
//                        }
                    }//}
//                        latitude=object.getString("latitude");
//                        longitude=object.getString("longitude");

                    hidepDialog();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                TableLayout tableLayout=(TableLayout)findViewById(R.id.tablelayout);
                tableLayout.removeAllViews();

                // Add header row
                TableRow rowHeader = new TableRow(DiningWesternDetail.this);

                String[] headerText={"MENU","HARGA"};
                for(String c:headerText) {
                    TextView tv = new TextView(DiningWesternDetail.this);
                    tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                            TableRow.LayoutParams.WRAP_CONTENT));
                    tv.setTextColor(Color.WHITE);
                    tv.setTextSize(14);

                    tv.setPadding(5, 5, 5, 5);
                    tv.setText(c);
                    rowHeader.addView(tv);
                }
                tableLayout.addView(rowHeader);

                String[][] local_admin = new String[menu.length][];
                for(int i=0;i<menu.length;i++){
                    local_admin[i] = new String[]{menu[i],harga[i]};
                }

                for(int i=0;i<menu.length;i++){
                    TableRow row = new TableRow(DiningWesternDetail.this);
                    row.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                            TableLayout.LayoutParams.WRAP_CONTENT));

                    for(String text:local_admin[i]) {
                        final TextView tv = new TextView(DiningWesternDetail.this);
                        tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                                TableRow.LayoutParams.WRAP_CONTENT));
                        tv.setTextColor(Color.WHITE);
                        tv.setTextSize(16);
                        tv.setPadding(10, 10, 10, 10);
                        if(text.equalsIgnoreCase("Pending")){
                            tv.setText(text);
                            tv.setId(Integer.parseInt(local_admin[i][0]));
                            tv.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //Toast.makeText(MainActivity.this,"ID : "+tv.getId(),Toast.LENGTH_LONG).show();
                                    //updateStatus(tv.getId());
                                }
                            });
                        }
                        else if(text.equalsIgnoreCase("Active")){
                            tv.setText(text);

                        }
                        else{
                            tv.setText(text);
                        }
                        row.addView(tv);
                    }
                    tableLayout.addView(row);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                String credentials = "admin:1234";
                String auth = "Basic " + Base64.encodeToString(credentials.getBytes(),    Base64.NO_WRAP);
                headers.put("Content-Type", "application/json");
                headers.put("Authorization", auth);
                return headers;
            }};
        hidepDialog();
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }
    private void initPDialog() {
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.setCanceledOnTouchOutside(false);
    }

    private void initView() {
        //initialization Button
        btn_map = (Button) findViewById(R.id.btn_map);
        btn_bookmark = (Button) findViewById(R.id.btn_bookmark);
        btn_photo = (Button) findViewById(R.id.btn_photo);
        //initiailzation TextView
        txt_name = (TextView) findViewById(R.id.name);
        txt_address = (TextView) findViewById(R.id.address);
        txt_open = (TextView) findViewById(R.id.open);
        txt_close = (TextView) findViewById(R.id.close);
        txt_phone = (TextView) findViewById(R.id.phone);
        txt_specialOffer = (TextView) findViewById(R.id.specialOffer);
        imageView = (NetworkImageView) findViewById(R.id.backdrop);
        txt_info = (TextView) findViewById(R.id.info);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home){
            this.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
    private void showpDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    // Hide dialog
    private void hidepDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
}