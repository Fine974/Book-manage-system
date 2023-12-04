package com.fine.bookmanagesystem.service;

import com.fine.bookmanagesystem.model.Order;

import java.util.List;

public interface OrderService {

    void createOrder(Order order);

    List<Order> getOrdersByUserId(int userId);

    Order getOrderById(int orderId);
}