package com.fine.bookmanagesystem.controller;

import com.fine.bookmanagesystem.model.Cart;
import com.fine.bookmanagesystem.model.Product;
import com.fine.bookmanagesystem.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // Display the user's cart
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    @GetMapping("")
    public String viewCart(@RequestParam Integer userId, Model model) {
        List<Cart> cartItems = cartService.getCartItemsByUserId(userId);
        model.addAttribute("cartItems", cartItems);
        return "cart/view";
    }


    // Add a book to the user's cart
    @PostMapping("/add")
    public String addToCart(@RequestParam Integer userId, @RequestParam Integer bookId, @RequestParam Integer quantity) {
        Cart cartItem = new Cart();
        cartItem.setUserId(userId);
        cartItem.setBookId(bookId);
        cartItem.setQuantity(quantity);

        cartService.addToCart(cartItem);
        return "redirect:/cart?userId=" + userId;
    }

    // Update the quantity of a book in the user's cart
    @PostMapping("/update")
    public String updateCartItemQuantity(@RequestParam Integer cartItemId, @RequestParam Integer quantity) {
        Cart cartItem = cartService.getCartItemById(cartItemId);
        cartItem.setQuantity(quantity);

        cartService.updateCartItemQuantity(cartItem);
        return "redirect:/cart?userId=" + cartItem.getUserId();
    }

    // Remove a book from the user's cart
    @GetMapping("/remove/{cartItemId}")
    public String removeFromCart(@PathVariable Integer cartItemId) {
        Cart cartItem = cartService.getCartItemById(cartItemId);
        cartService.removeFromCart(cartItemId);
        return "redirect:/cart?userId=" + cartItem.getUserId();
    }

    // Clear all items from the user's cart
    @GetMapping("/clear")
    public String clearCart(@RequestParam Integer userId) {
        cartService.clearCart(userId);
        return "redirect:/cart?userId=" + userId;
    }
}
