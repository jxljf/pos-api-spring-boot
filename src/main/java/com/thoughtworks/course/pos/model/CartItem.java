package com.thoughtworks.course.pos.model;

public class CartItem extends Item {
    private final int count;
    private final float totalPrice;

    public CartItem(String name, String unit, float price, String barcode, String img, int count, float totalPrice) {
        super(name, unit, price, barcode, img);
        this.count = count;
        this.totalPrice = totalPrice;
    }

    public int getCount() {
        return count;
    }

    public float getTotalPrice() {
        return totalPrice;
    }
}
