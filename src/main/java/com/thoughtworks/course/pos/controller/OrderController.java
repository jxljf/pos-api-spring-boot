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

    // TODO 增加获取一个资源的 @RequestMapping 注解
    public Collection<Order> getOrders() {
        return orderService.getOrders();
    }

    @RequestMapping(path = "/orders/{id}", method = RequestMethod.GET)
    public Order getOrder(@PathVariable Integer id) {
        // TODO 调用 orderService 指定 id 的 Order，并返回
        return null;
    }
}
