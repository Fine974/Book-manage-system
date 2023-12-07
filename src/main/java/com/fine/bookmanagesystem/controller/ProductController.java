package com.fine.bookmanagesystem.controller;

import com.fine.bookmanagesystem.model.Product;
import com.fine.bookmanagesystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@RestController
@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // 显示所有商品
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // 显示单个商品详情
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @GetMapping("")
    public String showProducts(Model model) {
        // Assuming you have a ProductService that provides product data
        List<Product> products = productService.getAllProducts();

        // Check if the product list is not empty
        if (!products.isEmpty()) {
            // Add the product list to the model
            model.addAttribute("products", products);
        } else {
            // If the product list is empty, you can add a message or handle it as needed
            model.addAttribute("noProductsMessage", "No products available");
        }

        // Return the name of the Thymeleaf template (products.html)
        return "products";
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


    @GetMapping("/{id}")
    public String getProductDetails(@PathVariable Integer id, Model model) {
        try {
            // 获取商品信息的逻辑
            Product product = productService.getProductById(id);

            if (product != null) {
                model.addAttribute("product", product);
                logger.info("Product details requested for id: {}", id);
                return "products/details"; // 返回模板名称
            } else {
                logger.warn("Product with id {} not found", id);
                return "error/404"; // 返回404页面或其他错误处理页面
            }
        } catch (Exception e) {
            logger.error("Error processing request for product details with id: {}", id, e);
            return "error/500"; // 返回500页面或其他错误处理页面
        }
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
    public String showUpdateProductForm(@PathVariable Integer id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "product/update"; // 这里假设有一个名为 "update.html" 的 Thymeleaf 模板用于显示更新商品的表单
    }

    // 处理更新商品的表单提交
    @PostMapping("/{id}/update")
    public String updateProduct(@PathVariable Integer id, @ModelAttribute Product product) {
        product.setId(id);
        productService.updateProduct(product);
        return "redirect:/products";
    }

    // 处理删除商品的请求
    @GetMapping("/{id}/delete")
    public String deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}
