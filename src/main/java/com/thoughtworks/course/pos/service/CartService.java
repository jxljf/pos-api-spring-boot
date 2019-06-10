package com.thoughtworks.course.pos.service;

import com.thoughtworks.course.pos.model.CartItem;
import com.thoughtworks.course.pos.model.Item;

import java.util.List;

public class CartService {
    private final List<Item> items;

    public CartService(List<Item> items) {
        this.items = items;
    }

    public List<CartItem> scan(List<String> barcodes) {
        // TODO implement scanning of barcodes
    }
}
