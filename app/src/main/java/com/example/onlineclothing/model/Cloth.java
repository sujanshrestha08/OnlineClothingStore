package com.example.onlineclothing.model;

public class Cloth {
    private String name;
    private String price;
    private int image;
    private String desc;

    public Cloth(String name, String price, int image, String desc) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
