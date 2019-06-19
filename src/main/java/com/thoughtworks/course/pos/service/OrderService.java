package com.thoughtworks.course.pos.service;

import com.thoughtworks.course.pos.model.*;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class OrderService {
    private final CartService cartService;
    private final PromotionService promotionService;
    private final Map<Integer, Order> orders = new ConcurrentHashMap<>();

    public OrderService(CartService cartService, PromotionService promotionService) {
        this.cartService = cartService;
        this.promotionService = promotionService;
    }

    public Order createOrder(List<String> barcodes) {
        final List<CartItem> cartItems = cartService.scan(barcodes);
        final List<DiscountedItem> discountedItems = promotionService.apply(cartItems);
        final Summary summary = new Summary(
                getTotalPrice(cartItems),
                getDiscountPrice(discountedItems)
                );
        final Integer id = orders.size();
        final Order order = new Order(id, cartItems, discountedItems, summary);
        orders.put(id, order);
        return order;
    }

    private int getTotalPrice(List<CartItem> cartItems) {
        int totalPrice = 0;
        for (CartItem item : cartItems) {
            totalPrice += item.totalPrice;
        }
        return totalPrice;
    }

    private int getDiscountPrice(List<DiscountedItem> discountedItems) {
        int discountPrice = 0;
        for (DiscountedItem item : discountedItems) {
            discountPrice += item.price * item.count;
        }
        return discountPrice;
    }

    public Collection<Order> getOrders() {
        return orders.values();
    }

    public Order getOrder(Integer id) {
        return orders.get(id);
    }
}
