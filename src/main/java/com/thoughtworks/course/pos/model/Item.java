package com.thoughtworks.course.pos.model;

public class Item {
    private final String name;
    private final String unit;
    private final float price;
    private final String barcode;
    private final String img;

    public Item(String name, String unit, float price, String barcode, String img) {
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.barcode = barcode;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public float getPrice() {
        return price;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getImg() {
        return img;
    }
}
