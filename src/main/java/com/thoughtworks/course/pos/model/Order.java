package com.thoughtworks.course.pos.model;

import java.util.List;

public class Order {
    public Integer id;
    public List<CartItem> cartItems;
    public List<DiscountedItem> discountProductList;

    public Order(Integer id, List<CartItem> cartItems, List<DiscountedItem> discountProductList, Summary summary) {
        this.id = id;
        this.cartItems = cartItems;
        this.discountProductList = discountProductList;
        this.summary = summary;
    }

    public Summary summary;
}
