package com.thoughtworks.course.pos.model;

/**
 * 优惠项目
 */
public class DiscountedItem extends ToString {
    public String name;
    public String unit;
    public int discounted;

    public DiscountedItem(String name, String unit, int discounted) {
        this.name = name;
        this.unit = unit;
        this.discounted = discounted;
    }
}
