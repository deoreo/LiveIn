package com.example.content.Model;

/**
 * Created by SMK Telkom SP Malang on 17/06/2016.
 */
public class NumberModel {
    private String title;

    public NumberModel( String title) {

        this.title = title;

    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title ;
    }
}


