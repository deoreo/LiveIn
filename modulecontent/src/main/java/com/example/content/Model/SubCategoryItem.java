package com.example.content.Model;

/**
 * Created by M. Asrof Bayhaqqi on 6/9/2016.
 */
public class SubCategoryItem {
    private int thumbnail;
    private String title;
    private String location;
    private String distance;

    public SubCategoryItem(int thumbnail, String title, String location, String distance) {
        this.thumbnail = thumbnail;
        this.title = title;
        this.location = location;
        this.distance = distance;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
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
