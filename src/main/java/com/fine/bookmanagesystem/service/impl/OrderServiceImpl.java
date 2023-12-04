package com.fine.bookmanagesystem.service.impl;

import com.fine.bookmanagesystem.dao.OrderDAO;
import com.fine.bookmanagesystem.model.Order;
import com.fine.bookmanagesystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDAO orderDAO;

    @Autowired
    public OrderServiceImpl(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public void placeOrder(Order order) {
        orderDAO.createOrder(order);
    }
}