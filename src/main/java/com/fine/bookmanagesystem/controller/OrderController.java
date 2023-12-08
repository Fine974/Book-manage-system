package com.fine.bookmanagesystem.controller;

import com.fine.bookmanagesystem.model.Order;
import com.fine.bookmanagesystem.model.Product;
import com.fine.bookmanagesystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public void createOrder(@RequestBody Order order) {
        orderService.createOrder(order);
    }

    @GetMapping("/user/{userId}")
    public String getOrdersByUserId(@PathVariable Integer userId, Model model) {
        List<Order> order = orderService.getOrdersByUserId(userId);
        model.addAttribute("order", order);
        return "orders";
    }

    @GetMapping("/{orderId}")
    public Order getOrderById(@PathVariable Integer orderId) {
        return orderService.getOrderById(orderId);
    }
}