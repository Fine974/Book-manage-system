package com.fine.bookmanagesystem.controller;

import com.fine.bookmanagesystem.model.Product;
import com.fine.bookmanagesystem.model.User;
import com.fine.bookmanagesystem.service.ProductService;
import com.fine.bookmanagesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ManagementController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @GetMapping("/productsAll")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/usersAll")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }
}
