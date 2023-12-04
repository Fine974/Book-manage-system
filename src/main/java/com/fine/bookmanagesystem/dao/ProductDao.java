package com.fine.bookmanagesystem.dao;

import com.fine.bookmanagesystem.model.Product;

import java.util.List;


public interface ProductDao {

    // 查询所有商品
    List<Product> getAllProducts();

    // 根据ID查询商品
    Product getProductById(Long id);

    // 添加商品
    void addProduct(Product product);

    // 更新商品信息
    void updateProduct(Product product);

    // 删除商品
    void deleteProduct(Long id);
}
