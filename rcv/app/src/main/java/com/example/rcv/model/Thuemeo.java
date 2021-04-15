package com.example.rcv.model;

public class Thuemeo {
    private int rsImg;
    private String money;
    private int id;
    private String time;
    private float rating;
    private String gender;

    public Thuemeo(int rsImg, String money, int id, String time, float rating,String gender) {
        this.rsImg = rsImg;
        this.money= money;
        this.id = id;
        this.time = time;
        this.rating = rating;
        this.gender=gender;
    }

    public int getRsImg() {
        return rsImg;
    }

    public String getMoney() {
        return money;
    }

    public int getId() {
        return id;
    }

    public String getTime() {
        return time;
    }

    public float getRating() {
        return rating;
    }

    public String getGender() {
        return gender;
    }
}
