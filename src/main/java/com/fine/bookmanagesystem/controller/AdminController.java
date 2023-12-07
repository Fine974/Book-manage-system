package com.fine.bookmanagesystem.controller;

import com.fine.bookmanagesystem.model.Product;
import com.fine.bookmanagesystem.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/adminIndex")
public class AdminController {

    private ProductService productService;
    @RequestMapping("")
    public String login() {
        return "adminIndex";
    }

    @GetMapping("/showAll")
    public String showProductAll(Model model) {
        List<Product> products = productService.getAllProducts();

        // 如果商品列表为空，可以添加一个自定义的消息
        if (products.isEmpty()) {
            model.addAttribute("noProductsMessage", "当前没有商品可显示。");
        }

        // 将商品列表添加到模型中
        model.addAttribute("products", products);

        // 返回对应的Thymeleaf模板名称
        return "adminIndex"; // 这里假设您的Thymeleaf模板名称是 adminIndex.html
    }
}
