package com.fine.bookmanagesystem.controller;

import com.fine.bookmanagesystem.model.Product;
import com.fine.bookmanagesystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // 显示所有商品
    @GetMapping
    public String getAllProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "product/list"; // 这里假设有一个名为 "list.html" 的 Thymeleaf 模板用于显示商品列表
    }

    // 显示单个商品详情
    @GetMapping("/{id}")
    public String getProductDetails(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "product/details"; // 这里假设有一个名为 "details.html" 的 Thymeleaf 模板用于显示商品详情
    }

    // 处理添加商品的页面请求
    @GetMapping("/add")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "product/add"; // 这里假设有一个名为 "add.html" 的 Thymeleaf 模板用于显示添加商品的表单
    }

    // 处理添加商品的表单提交
    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product) {
        productService.addProduct(product);
        return "redirect:/products";
    }

    // 处理更新商品的页面请求
    @GetMapping("/{id}/update")
    public String showUpdateProductForm(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "product/update"; // 这里假设有一个名为 "update.html" 的 Thymeleaf 模板用于显示更新商品的表单
    }

    // 处理更新商品的表单提交
    @PostMapping("/{id}/update")
    public String updateProduct(@PathVariable int id, @ModelAttribute Product product) {
        product.setId(id);
        productService.updateProduct(product);
        return "redirect:/products";
    }

    // 处理删除商品的请求
    @GetMapping("/{id}/delete")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}
