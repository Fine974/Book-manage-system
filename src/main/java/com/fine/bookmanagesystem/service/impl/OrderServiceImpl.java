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
    public List<Order> getOrdersByUserId(Long userId) {
        return orderMapper.getOrdersByUserId(userId);
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderMapper.getOrderById(orderId);
    }
}