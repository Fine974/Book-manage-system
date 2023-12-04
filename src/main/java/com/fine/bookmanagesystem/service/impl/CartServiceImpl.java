package com.fine.bookmanagesystem.service.impl;

import com.fine.bookmanagesystem.dao.CartDao;
import com.fine.bookmanagesystem.model.Cart;
import com.fine.bookmanagesystem.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    private final CartDao cartDao;

    @Autowired
    public CartServiceImpl(CartDao cartDao) {
        this.cartDao = cartDao;
    }

    @Override
    public List<Cart> getCartItemsByUserId(Long userId) {
        return cartDao.getCartItemsByUserId(userId);
    }

    @Override
    public Cart getCartItemById(Long id) {
        return cartDao.getCartItemById(id);
    }

    @Override
    public void addToCart(Cart cartItem) {
        cartDao.addToCart(cartItem);
    }

    @Override
    public void updateCartItemQuantity(Cart cartItem) {
        cartDao.updateCartItemQuantity(cartItem);
    }

    @Override
    public void removeFromCart(Long id) {
        cartDao.removeFromCart(id);
    }

    @Override
    public void clearCart(Long userId) {
        cartDao.clearCart(userId);
    }
}
