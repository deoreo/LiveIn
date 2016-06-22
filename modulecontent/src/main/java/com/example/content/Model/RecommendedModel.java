package com.example.content.Model;

/**
 * Created by M. Asrof Bayhaqqi on 6/8/2016.
 */
public class RecommendedModel {
    private int rating;
    private String avatar, latitude, longitude, name, address, distance, subcategory, day, open, close;

    public RecommendedModel() {
    }

    public RecommendedModel(String avatar, String latitude, String longitude, String name, String address, String distance, String subcategory, int rating, String day, String open, String close) {
        this.avatar = avatar;
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.address = address;
        this.distance = distance;
        this.subcategory = subcategory;
        this.rating = rating;
        this.day = day;
        this.open = open;
        this.close = close;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }
}
