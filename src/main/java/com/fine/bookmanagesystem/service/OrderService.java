package com.fine.bookmanagesystem.service;

import com.fine.bookmanagesystem.model.Order;

import java.util.List;

public interface OrderService {

    void createOrder(Order order);

    List<Order> getOrdersByUserId(Long userId);

    Order getOrderById(Long orderId);
}