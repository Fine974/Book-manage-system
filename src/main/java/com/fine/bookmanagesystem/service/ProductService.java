package com.fine.bookmanagesystem.service;

import com.fine.bookmanagesystem.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(Long id);

    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(Long id);
}
