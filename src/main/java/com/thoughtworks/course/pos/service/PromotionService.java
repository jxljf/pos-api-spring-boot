package com.thoughtworks.course.pos.service;

import com.thoughtworks.course.pos.model.CartItem;
import com.thoughtworks.course.pos.model.DiscountedItem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PromotionService {
    private List<String> barcodes = Arrays.asList("ITEM000000", "ITEM000001", "ITEM000005");

    public List<DiscountedItem> apply(List<CartItem> cartItems) {
        List<DiscountedItem> discountedItems = new LinkedList<>();
        for (CartItem item : cartItems) {
            if (barcodes.contains(item.barcode)) {
                int discounted = item.count / 3;
                if (discounted > 0) {
                    discountedItems.add(new DiscountedItem(item.name, item.unit, discounted));
                }
            }
        }
        return discountedItems;
    }
}
