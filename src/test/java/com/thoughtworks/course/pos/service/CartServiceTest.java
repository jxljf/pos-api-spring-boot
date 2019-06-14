package com.thoughtworks.course.pos.service;

import com.thoughtworks.course.pos.model.CartItem;
import com.thoughtworks.course.pos.model.Item;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CartServiceTest {

    private CartService cartService;

    @Before
    public void setUp() {
        cartService = new CartService();
    }

    @Test
    public void shouldScanInstantNoodle() {
        List<CartItem> cartItems = cartService.scan(Collections.singletonList("ITEM000000"));
        assertEquals("Cart Size", 1, cartItems.size());
        assertEquals("Item Name", "方便面", cartItems.get(0).name);
        assertEquals("Item Count", 1, cartItems.get(0).count);
    }

    @Test
    public void shouldScanInstantNoodleTwice() {
        List<CartItem> cartItems = cartService.scan(Arrays.asList("ITEM000000", "ITEM000000"));
        assertEquals("Cart Size", 1, cartItems.size());
        assertEquals("Item Name", "方便面", cartItems.get(0).name);
        assertEquals("Item Count", 2, cartItems.get(0).count);
    }

    @Test
    public void shouldScanInstantNoodleWithCount() {
        List<CartItem> cartItems = cartService.scan(Collections.singletonList("ITEM000000-2"));
        assertEquals("Cart Size", 1, cartItems.size());
        assertEquals("Item Name", "方便面", cartItems.get(0).name);
        assertEquals("Item Count", 2, cartItems.get(0).count);
    }

    @Test
    public void shouldMergeSameItems() {
        List<CartItem> cartItems = cartService.scan(Arrays.asList("ITEM000000", "ITEM000000-2"));
        assertEquals("Cart Size", 1, cartItems.size());
        assertEquals("Item Name", "方便面", cartItems.get(0).name);
        assertEquals("Item Count", 3, cartItems.get(0).count);
    }
}
