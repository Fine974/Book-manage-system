package com.fine.bookmanagesystem.mapper;

import com.fine.bookmanagesystem.model.Product;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper

public interface ProductMapper {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(Long id);
}
