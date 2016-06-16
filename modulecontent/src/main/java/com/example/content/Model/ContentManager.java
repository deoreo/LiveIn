package com.example.content.Model;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by M. Asrof Bayhaqqi on 6/16/2016.
 */
public class ContentManager {

    public static final String PREFS_NAME = "SmartCity";
    public static final String HOTEL = "Hotel";

    public void saveHotel(Context context, List<Hotel> hotel) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);
        editor = settings.edit();

        Gson gson = new Gson();
        String jsonHotel= gson.toJson(hotel);
        editor.putString(HOTEL, jsonHotel);

        editor.commit();
    }

    public ArrayList<Hotel> getHotel(Context context) {
        SharedPreferences settings;
        List<Hotel> hotels;

        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);

        if (settings.contains(HOTEL)) {
            String jsonFavorites = settings.getString(HOTEL, null);
            Gson gson = new Gson();
            Hotel[] favoriteItems = gson.fromJson(jsonFavorites,
                    Hotel[].class);

            hotels = Arrays.asList(favoriteItems);
            hotels = new ArrayList<Hotel>(hotels);
        } else
            return null;

        return (ArrayList<Hotel>) hotels;
    }
}
