package com.fine.bookmanagesystem.dao.impl;

import com.fine.bookmanagesystem.dao.CartDao;
import com.fine.bookmanagesystem.mapper.CartMapper;
import com.fine.bookmanagesystem.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartDaoImpl implements CartDao {

    private final CartMapper cartMapper;

    @Autowired
    public CartDaoImpl(CartMapper cartMapper) {
        this.cartMapper = cartMapper;
    }

    @Override
    public List<Cart> getCartItemsByUserId(Long userId) {
        return cartMapper.getCartItemsByUserId(userId);
    }

    @Override
    public Cart getCartItemById(Long id) {
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
    public void removeFromCart(Long id) {
        cartMapper.removeFromCart(id);
    }

    @Override
    public void clearCart(Long userId) {
        cartMapper.clearCart(userId);
    }
}
