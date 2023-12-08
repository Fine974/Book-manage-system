package com.fine.bookmanagesystem.controller;

import com.fine.bookmanagesystem.model.Cart;
import com.fine.bookmanagesystem.model.Order;
import com.fine.bookmanagesystem.service.CartService;
import com.fine.bookmanagesystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final CartService cartService;
    @Autowired
    public OrderController(OrderService orderService, CartService cartService) {
        this.orderService = orderService;
        this.cartService = cartService;
    }

    @PostMapping("/create")
    public String createOrder(@RequestBody Order order) {
        orderService.createOrder(order);
        return "redirect:/orders";
    }

    @GetMapping("/placeOrder/{cartItemId}")
    public String placeOrder(@PathVariable("cartItemId") int cartItemId) {
        // 获取购物车项信息，然后调用服务层完成下单操作
        Cart cartItem = cartService.getCartItemById(cartItemId); // 请根据实际情况替换为获取购物车项的方法
        Order order = new Order();
        order.setUserId(cartItem.getUserId());
        order.setProductId(cartItem.getBookId());
        order.setQuantity(cartItem.getQuantity());
        order.setTotalPrice(cartItem.getBookPrice() * cartItem.getQuantity());
        order.setOrderDate(new Date());
        orderService.createOrder(order);
        cartService.removeFromCart(cartItem.getId());
        return "redirect:/orders/user/" + cartItem.getUserId();
    }

    @GetMapping("/all")
    public String clearCart(@RequestParam Integer userId) {
        List<Cart> cartItems = cartService.getCartItemsByUserId(userId);
        int len = cartItems.size();
        for(int i = 0; i < len; ++i) {
            Cart cartItem = cartItems.get(i);
            Order order = new Order();
            order.setUserId(cartItem.getUserId());
            order.setProductId(cartItem.getBookId());
            order.setQuantity(cartItem.getQuantity());
            order.setTotalPrice(cartItem.getBookPrice() * cartItem.getQuantity());
            order.setOrderDate(new Date());
            orderService.createOrder(order);
        }
        cartService.clearCart(userId);
        return "redirect:/orders/user/" + userId;
    }

    @GetMapping("/user/{userId}")
    public String getOrdersByUserId(@PathVariable Integer userId, Model model) {
        List<Order> order = orderService.getOrdersByUserId(userId);
        System.out.println(order);
        model.addAttribute("order", order);
        return "orders";
    }

    @GetMapping("/{orderId}")
    public Order getOrderById(@PathVariable Integer orderId) {
        return orderService.getOrderById(orderId);
    }
}