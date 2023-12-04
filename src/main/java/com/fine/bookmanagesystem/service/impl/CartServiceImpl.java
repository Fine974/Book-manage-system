package com.fine.bookmanagesystem.service.impl;

import com.fine.bookmanagesystem.mapper.CartMapper;
import com.fine.bookmanagesystem.model.Cart;
import com.fine.bookmanagesystem.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    private final CartMapper cartMapper;

    @Autowired
    public CartServiceImpl(CartMapper cartMapper) {
        this.cartMapper = cartMapper;
    }

    @Override
    public List<Cart> getCartItemsByUserId(Integer userId) {
        return cartMapper.getCartItemsByUserId(userId);
    }

    @Override
    public Cart getCartItemById(Integer id) {
        return cartMapper.getCartItemById(id);
    }

    @Override
    public void addToCart(Cart cartItem) {
        cartMapper.addToCart(cartItem);
    }

    @Override
    public void updateCartItemQuantity(Cart cartItem) {
        cartMapper.updateCartItemQuantity(cartItem);
    }

    @Override
    public void removeFromCart(Integer id) {
        cartMapper.removeFromCart(id);
    }

    @Override
    public void clearCart(Integer userId) {
        cartMapper.clearCart(userId);
    }
}
