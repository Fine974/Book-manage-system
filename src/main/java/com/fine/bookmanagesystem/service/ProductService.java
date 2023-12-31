package com.fine.bookmanagesystem.service;

import com.fine.bookmanagesystem.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(int id);

    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(int id);
}
