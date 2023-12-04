package com.fine.bookmanagesystem.service;

import com.fine.bookmanagesystem.model.Cart;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CartService {

    List<Cart> getCartItemsByUserId(Long userId);

    Cart getCartItemById(Long id);

    void addToCart(Cart cartItem);

    void updateCartItemQuantity(Cart cartItem);

    void removeFromCart(Long id);

    void clearCart(Long userId);
}
