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
    private final Item instantNoodle = new Item("方便面", "袋", 4.50f, "ITEM000000", "./imgs/instant-noodles.jpeg");
    private final Item badminton = new Item("羽毛球", "个", 1.00f, "ITEM000001", "./imgs/badminton.png");
    private final Item litchi = new Item("荔枝", "斤", 15.00f, "ITEM000002", "./imgs/litchi.jpg");
    private final Item apple = new Item("苹果", "斤", 5.50f, "ITEM000003", "./imgs/apple.jpeg");
    private final Item battery = new Item("电池", "个", 2.00f, "ITEM000004", "./imgs/battery.jpeg");
    private final Item cola = new Item("可口可乐", "瓶", 3.00f, "ITEM000005", "./imgs/coco-cola.jpg");

    private CartService cartService;

    @Before
    public void setUp() {
        cartService = new CartService(Arrays.asList(
                instantNoodle,
                badminton,
                litchi,
                apple,
                battery,
                cola
        ));
    }

    @Test
    public void shouldScanInstantNoodle() {
        List<CartItem> cartItems = cartService.scan(Collections.singletonList("ITEM000000"));
        assertEquals("Cart Size", 1, cartItems.size());
        assertEquals("Item Name", "方便面", cartItems.get(0).getName());
        assertEquals("Item Count", 1, cartItems.get(0).getCount());
    }

    @Test
    public void shouldScanInstantNoodleTwice() {
        List<CartItem> cartItems = cartService.scan(Arrays.asList("ITEM000000", "ITEM000000"));
        assertEquals("Cart Size", 1, cartItems.size());
        assertEquals("Item Name", "方便面", cartItems.get(0).getName());
        assertEquals("Item Count", 2, cartItems.get(0).getCount());
    }

    @Test
    public void shouldScanInstantNoodleWithSuffix() {
        List<CartItem> cartItems = cartService.scan(Collections.singletonList("ITEM000000-2"));
        assertEquals("Cart Size", 1, cartItems.size());
        assertEquals("Item Name", "方便面", cartItems.get(0).getName());
        assertEquals("Item Count", 2, cartItems.get(0).getCount());
    }

    @Test
    public void shouldMergeSameItems() {
        List<CartItem> cartItems = cartService.scan(Arrays.asList("ITEM000000", "ITEM000000-2"));
        assertEquals("Cart Size", 1, cartItems.size());
        assertEquals("Item Name", "方便面", cartItems.get(0).getName());
        assertEquals("Item Count", 3, cartItems.get(0).getCount());
    }
}
