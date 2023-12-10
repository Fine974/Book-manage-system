package com.fine.bookmanagesystem.controller;

import com.fine.bookmanagesystem.model.Product;
import com.fine.bookmanagesystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/adminIndex")
public class AdminController {

    private final ProductService productService;

    @Autowired
    public AdminController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("")
    public String adminIndex(Model model) {
        model.addAttribute("product", new Product());
        return "adminIndex";
    }

    @GetMapping("/showAll")
    public String showProductAll(Model model) {
        List<Product> products = productService.getAllProducts();

        if (products.isEmpty()) {
            model.addAttribute("noProductsMessage", "当前没有商品可显示。");
        } else {
            model.addAttribute("products", products);
        }

        return "adminIndex"; // 确保 Thymeleaf 模板的名称是 adminIndex.html
    }
}
