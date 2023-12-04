package com.fine.bookmanagesystem.dao;

import com.fine.bookmanagesystem.model.Cart;

import java.util.List;

public interface CartDao {

    // Get all cart items for a specific user
    List<Cart> getCartItemsByUserId(Long userId);

    // Get a specific cart item by ID
    Cart getCartItemById(Long id);

    // Add a book to the user's cart
    void addToCart(Cart cartItem);

    // Update the quantity of a book in the user's cart
    void updateCartItemQuantity(Cart cartItem);

    // Remove a book from the user's cart
    void removeFromCart(Long id);

    // Clear all items from the user's cart
    void clearCart(Long userId);
}
