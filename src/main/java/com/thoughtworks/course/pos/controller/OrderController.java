package com.thoughtworks.course.pos.controller;

import com.thoughtworks.course.pos.model.Order;
import com.thoughtworks.course.pos.service.OrderService;
import org.springframework.web.bind.annotation.*;

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
        return orderService.getOrders();
    }

    @RequestMapping(path = "/orders/{id}", method = RequestMethod.GET)
    public Order getOrder(@PathVariable Integer id) {
        return orderService.getOrder(id);
    }
}
