package com.thoughtworks.course.pos.controller;

import com.thoughtworks.course.pos.model.Order;
import com.thoughtworks.course.pos.service.OrderService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(path = "/orders", method = RequestMethod.POST)
    public Order createOrder(@RequestBody List<String> barcodes) {
        return orderService.createOrder(barcodes);
    }

    @RequestMapping(path = "/orders", method = RequestMethod.GET)
    public Collection<Order> getOrders() {
        // TODO 调用 orderService 获取所有 Order，并返回
        return null;
    }
}
