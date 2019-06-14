package com.thoughtworks.course.pos;

import com.thoughtworks.course.pos.model.CartItem;
import com.thoughtworks.course.pos.model.DiscountedItem;
import com.thoughtworks.course.pos.service.CartService;
import com.thoughtworks.course.pos.service.PromotionService;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        CartService cartService = new CartService();
        PromotionService promotionService = new PromotionService();
        List<String> input = Arrays.asList(
                "ITEM000001",
                "ITEM000001",
                "ITEM000001",
                "ITEM000001",
                "ITEM000001",
                "ITEM000003-2",
                "ITEM000005",
                "ITEM000005",
                "ITEM000005"
        );
        final List<CartItem> cartItems = cartService.scan(input);
        final List<DiscountedItem> discountedItems = promotionService.apply(cartItems);
        System.out.println("cartItems = " + discountedItems);
        System.out.println("discountedItems = " + discountedItems);
    }
}
