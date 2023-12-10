package com.fine.bookmanagesystem.service;

import com.fine.bookmanagesystem.model.Order;
import com.fine.bookmanagesystem.model.User;

import java.util.List;

public interface OrderService {

    void createOrder(Order order);

    List<Order> getOrdersByUserId(int userId);


    List<Order> getAllOrders();


    Order getOrderById(int orderId);
}