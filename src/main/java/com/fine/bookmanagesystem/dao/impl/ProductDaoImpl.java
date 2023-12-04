package com.fine.bookmanagesystem.dao.impl;

import com.fine.bookmanagesystem.dao.ProductDao;
import com.fine.bookmanagesystem.mapper.ProductMapper;
import com.fine.bookmanagesystem.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    private final ProductMapper productMapper;

    @Autowired
    public ProductDaoImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public List<Product> getAllProducts() {
        return productMapper.getAllProducts();
    }

    @Override
    public Product getProductById(Long id) {
        return productMapper.getProductById(id);
    }

    @Override
    public void addProduct(Product product) {
        productMapper.addProduct(product);
    }

    @Override
    public void updateProduct(Product product) {
        productMapper.updateProduct(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productMapper.deleteProduct(id);
    }
}
