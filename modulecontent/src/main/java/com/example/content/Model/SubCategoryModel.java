package com.example.content.Model;

/**
 * Created by Lenovo on 20/06/2016.
 */

public class SubCategoryModel {
    private String id_tenant, avatar, latitude, longitude, name, address, distance, subcategory;

    public SubCategoryModel() {
    }

    public SubCategoryModel(String id_tenant, String avatar, String latitude, String longitude, String name, String address, String distance, String subcategory) {
        this.id_tenant = id_tenant;
        this.avatar = avatar;
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.address = address;
        this.distance = distance;
        this.subcategory = subcategory;
    }

    public String getIdtenant() {
        return id_tenant;
    }

    public void setIdtenant(String id_tenant) {
        this.id_tenant = id_tenant;
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


}

