package com.thoughtworks.course.pos.model;

import java.util.List;

public class Order {
    public List<CartItem> cartItems;
    public List<DiscountedItem> discountProductList;

    public Order(List<CartItem> cartItems, List<DiscountedItem> discountProductList, Summary summary) {
        this.cartItems = cartItems;
        this.discountProductList = discountProductList;
        this.summary = summary;
    }

    public Summary summary;
}
