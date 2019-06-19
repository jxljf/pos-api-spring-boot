package com.thoughtworks.course.pos.model;

/**
 * 优惠项目
 */
public class DiscountedItem extends ToString {
    public String name;
    public String unit;
    public float price;
    public int count;

    public DiscountedItem(String name, String unit, float price, int count) {
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.count = count;
    }
}
