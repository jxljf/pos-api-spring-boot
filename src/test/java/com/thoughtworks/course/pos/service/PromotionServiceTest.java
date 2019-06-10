package com.thoughtworks.course.pos.service;

import com.thoughtworks.course.pos.model.CartItem;
import com.thoughtworks.course.pos.model.DiscountedItem;
import com.thoughtworks.course.pos.model.Promotion;
import com.thoughtworks.course.pos.model.PromotionType;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class PromotionServiceTest {
    private final CartItem twoInstantNoodle = new CartItem("方便面", "袋", 4.50f, "ITEM000000", "./imgs/instant-noodles.jpeg", 2, 9.0f);
    private final CartItem threeInstantNoodle = new CartItem("方便面", "袋", 4.50f, "ITEM000000", "./imgs/instant-noodles.jpeg", 3, 13.5f);
    private final Promotion promotion = new Promotion(PromotionType.BUY_TWO_GET_ONE_FREE, Collections.singletonList("ITEM000000"));

    private PromotionService promotionService;

    @Before
    public void setUp() {
        promotionService = new PromotionService(Collections.singletonList(promotion));
    }

    @Test
    public void shouldNotDiscountWhen2InChart() {
        List<DiscountedItem> discountedItems = promotionService.apply(Collections.singletonList(twoInstantNoodle));
        assertEquals("List Count", 0, discountedItems.size());
    }

    @Test
    public void shouldDiscount1When3InChart() {
        List<DiscountedItem> cartItems = promotionService.apply(Collections.singletonList(threeInstantNoodle));
        assertEquals("List Count", 1, cartItems.size());
        assertEquals("Item Name", "方便面", cartItems.get(0).getName());
        assertEquals("Item Count", 1, cartItems.get(0).getCount());
    }
}
