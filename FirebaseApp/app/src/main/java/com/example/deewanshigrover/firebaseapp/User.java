package com.example.deewanshigrover.firebaseapp;

/**
 * Created by DEEWANSHI GROVER on 27-10-2018.
 */

public class User {
    private String nem;
    private String email;
    private String phn;
    private String proj;
    private String tech;

    public User() {
    }

    public User(String nem, String email, String phn, String proj, String tech) {
        this.nem = nem;
        this.email = email;
        this.phn = phn;
        this.proj = proj;
        this.tech = tech;
    }

    public String getNem() {
        return nem;
    }

    public void setNem(String nem) {
        this.nem = nem;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhn() {
        return phn;
    }

    public void setPhn(String phn) {
        this.phn = phn;
    }

    public String getProj() {
        return proj;
    }

    public void setProj(String proj) {
        this.proj = proj;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }
}
