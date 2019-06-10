package com.thoughtworks.course.pos.service;

import com.thoughtworks.course.pos.model.CartItem;
import com.thoughtworks.course.pos.model.DiscountedItem;
import com.thoughtworks.course.pos.model.Promotion;

import java.util.List;

public class PromotionService {
    private final List<Promotion> promotions;

    public PromotionService(List<Promotion> promotions) {
        this.promotions = promotions;
    }

    public List<DiscountedItem> apply(List<CartItem> cartItems) {
        // TODO implement applying promotion for chart items
        throw new RuntimeException("Not implemented");
    }
}
