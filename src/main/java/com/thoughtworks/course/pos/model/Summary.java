package com.thoughtworks.course.pos.model;

public class Summary {
    public float totalPrice;
    public float discountPrice;

    public Summary(float totalPrice, float discountPrice) {
        this.totalPrice = totalPrice;
        this.discountPrice = discountPrice;
    }
}
