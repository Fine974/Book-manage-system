package com.fine.bookmanagesystem.mapper;

import com.fine.bookmanagesystem.model.Cart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper {

    List<Cart> getCartItemsByUserId(Integer userId);

    Cart getCartItemById(Integer id);

    void addToCart(Cart cartItem);

    void updateCartItemQuantity(Cart cartItem);

    void removeFromCart(Integer id);

    void clearCart(Integer userId);
}
