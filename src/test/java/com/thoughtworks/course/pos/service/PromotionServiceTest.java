package com.thoughtworks.course.pos.service;

import com.thoughtworks.course.pos.model.CartItem;
import com.thoughtworks.course.pos.model.DiscountedItem;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class PromotionServiceTest {
    private final CartItem twoInstantNoodle = new CartItem("方便面", "袋", 4.50f, "ITEM000000", "./imgs/instant-noodles.jpeg", 2, 9.0f);
    private final CartItem threeInstantNoodle = new CartItem("方便面", "袋", 4.50f, "ITEM000000", "./imgs/instant-noodles.jpeg", 3, 13.5f);
    private final CartItem sevenInstantNoodle = new CartItem("方便面", "袋", 4.50f, "ITEM000000", "./imgs/instant-noodles.jpeg", 7, 31.5f);
    private final CartItem threeApple = new CartItem("苹果", "斤", 5.50f, "ITEM000003", "./imgs/apple.jpeg", 3, 16.5f);

    private PromotionService promotionService;

    @Before
    public void setUp() {
        promotionService = new PromotionService();
    }

    @Test
    public void shouldNotDiscountWhen2InChart() {
        List<DiscountedItem> discountedItems = promotionService.apply(Collections.singletonList(twoInstantNoodle));
        assertEquals("List Count", 0, discountedItems.size());
    }

    @Test
    public void shouldDiscount1When3InChart() {
        List<DiscountedItem> discountedItems = promotionService.apply(Collections.singletonList(threeInstantNoodle));
        assertEquals("List Count", 1, discountedItems.size());
        assertEquals("Item Name", "方便面", discountedItems.get(0).name);
        assertEquals("Item Count", 1, discountedItems.get(0).discounted);
    }

    @Test
    public void shouldDiscount2When7InChart() {
        List<DiscountedItem> discountedItems = promotionService.apply(Collections.singletonList(sevenInstantNoodle));
        assertEquals("List Count", 1, discountedItems.size());
        assertEquals("Item Name", "方便面", discountedItems.get(0).name);
        assertEquals("Item Count", 2, discountedItems.get(0).discounted);
    }

    @Test
    public void shouldNotDiscountApple() {
        List<DiscountedItem> discountedItems = promotionService.apply(Collections.singletonList(threeApple));
        assertEquals("List Count", 0, discountedItems.size());
    }
}
