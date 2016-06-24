package com.example.login.Activity;

import android.app.Application;

import com.example.login.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by chris on 06/05/2014.
 * For Calligraphy.
 */
public class CalligraphyApplication extends Application {

    public CalligraphyApplication(){

    }

    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/HelveticaNeue-Light.otf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}