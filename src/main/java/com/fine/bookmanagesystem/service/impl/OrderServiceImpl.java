package com.fine.bookmanagesystem.service.impl;

import com.fine.bookmanagesystem.mapper.OrderMapper;
import com.fine.bookmanagesystem.model.Order;
import com.fine.bookmanagesystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public void createOrder(Order order) {
        orderMapper.createOrder(order);
    }

    @Override
    public List<Order> getOrdersByUserId(int userId) {
        return orderMapper.getOrdersByUserId(userId);
    }

    @Override
    public Order getOrderById(int orderId) {
        return orderMapper.getOrderById(orderId);
    }

    @Override
    public void deleteOrder(Integer id) {
        orderMapper.deleteOrder(id);
    }

    public List<Order> getAllOrders() {
        List<Order> orders = orderMapper.getAllOrders();
        System.out.println("Number of orders retrieved: " + orders.size());
        return orders;
    }
}