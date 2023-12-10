package com.fine.bookmanagesystem.controller;

import com.fine.bookmanagesystem.model.Order;
import com.fine.bookmanagesystem.model.Product;
import com.fine.bookmanagesystem.model.User;
import com.fine.bookmanagesystem.service.OrderService;
import com.fine.bookmanagesystem.service.ProductService;
import com.fine.bookmanagesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiManagementController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/productsAll")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }
    @GetMapping("/add")
    public List<Product> addProduct() {
        return productService.getAllProducts();
    }
    @GetMapping("/usersAll")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/ordersAll")
    public List<Order> getOrders() {
        return orderService.getAllOrders();
    }
}
