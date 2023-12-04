package com.fine.bookmanagesystem.service;

import com.fine.bookmanagesystem.model.Cart;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CartService {

    List<Cart> getCartItemsByUserId(Integer userId);

    Cart getCartItemById(Integer id);

    void addToCart(Cart cartItem);

    void updateCartItemQuantity(Cart cartItem);

    void removeFromCart(Integer id);

    void clearCart(Integer userId);
}
