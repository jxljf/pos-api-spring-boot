package com.thoughtworks.course.pos.model;

public class DiscountedItem {
    private final String name;
    private final String unit;
    private final int count;

    public DiscountedItem(String name, String unit, int count) {
        this.name = name;
        this.unit = unit;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public int getCount() {
        return count;
    }
}
