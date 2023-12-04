package com.fine.bookmanagesystem.controller;

import com.fine.bookmanagesystem.model.Order;
import com.fine.bookmanagesystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/placeOrder")
    public String placeOrder(@RequestBody Order order) {
        try {
            orderService.placeOrder(order);
            return "Order placed successfully!";
        } catch (Exception e) {
            return "Failed to place order. Error: " + e.getMessage();
        }
    }
}