package com.fine.bookmanagesystem.dao.impl;

import com.fine.bookmanagesystem.dao.OrderDAO;
import com.fine.bookmanagesystem.mapper.OrderMapper;
import com.fine.bookmanagesystem.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDAOImpl implements OrderDAO {

    private final OrderMapper orderMapper;

    @Autowired
    public OrderDAOImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public void createOrder(Order order) {
        orderMapper.createOrder(order);
    }
}