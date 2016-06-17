package com.example.content.Model;

/**
 * Created by SMK Telkom SP Malang on 17/06/2016.
 */
public class InfoModel {
    private String title;
    private String location;
    private String distance;

    public InfoModel( String title, String location, String distance) {

        this.title = title;
        this.location = location;
        this.distance = distance;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title + "\n" + location + "\n" + distance;
    }
}


