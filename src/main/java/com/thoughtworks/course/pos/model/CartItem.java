package com.thoughtworks.course.pos.model;

/**
 * 购物车项目
 */
public class CartItem extends Item {
    public int count;
    public float totalPrice;

    public CartItem(String name, String unit, float price, String barcode, String img, int count, float totalPrice) {
        super(name, unit, price, barcode, img);
        this.count = count;
        this.totalPrice = totalPrice;
    }
}
