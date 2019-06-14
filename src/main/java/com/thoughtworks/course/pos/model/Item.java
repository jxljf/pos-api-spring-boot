package com.thoughtworks.course.pos.model;

/**
 * 商品
 */
public class Item extends ToString {
    public String name;
    public String unit;
    public float price;
    public String barcode;
    public String img;

    public Item(String name, String unit, float price, String barcode, String img) {
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.barcode = barcode;
        this.img = img;
    }
}
