package com.example.deewanshigrover.cardview;

import java.io.Serializable;

/**
 * Created by DEEWANSHI GROVER on 13-01-2019.
 */

public class Student implements Serializable {
    private int img;
    private String name;
    private String email;
    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
