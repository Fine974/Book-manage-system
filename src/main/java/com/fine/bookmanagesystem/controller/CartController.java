package com.fine.bookmanagesystem.controller;

import com.fine.bookmanagesystem.model.Cart;
import com.fine.bookmanagesystem.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // Display the user's cart
    @GetMapping
    public String viewCart(@RequestParam Integer userId, Model model) {
        List<Cart> cartItems = cartService.getCartItemsByUserId(userId);
        model.addAttribute("cartItems", cartItems);
        return "cart/view";  // Assuming you have a Thymeleaf template named "view.html" to display the cart
    }

    // Add a book to the user's cart
    @PostMapping("/add")
    public String addToCart(@RequestParam int userId, @RequestParam int bookId, @RequestParam int quantity) {
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
