package com.example.content.Model;

/**
 * Created by M. Asrof Bayhaqqi on 6/15/2016.
 */
public class Hotel {

    private int idtenant;
    private String avatar, name, address, phone, subcategory;

    public Hotel() {
    }

    public Hotel(int idtenant, String avatar, String name, String address, String phone, String subcategory) {
        this.idtenant = idtenant;
        this.avatar = avatar;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.subcategory = subcategory;
    }

    public int getIdtenant() {
        return idtenant;
    }

    public void setIdtenant(int idtenant) {
        this.idtenant = idtenant;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }
}
