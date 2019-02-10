package com.example.deewanshigrover.jan19;

/**
 * Created by DEEWANSHI GROVER on 20-01-2019.
 */

public class Student {

    private String nem;
    private String mob;
    private String ads;
    private String desg;

    public Student() {
    }

    public Student(String nem, String mob, String ads, String desg) {
        this.nem = nem;
        this.mob = mob;
        this.ads = ads;
        this.desg = desg;
    }


    public String getNem() {
        return nem;
    }

    public void setNem(String nem) {
        this.nem = nem;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getAds() {
        return ads;
    }

    public void setAds(String ads) {
        this.ads = ads;
    }

    public String getDesg() {
        return desg;
    }

    public void setDesg(String desg) {
        this.desg = desg;
    }
}
