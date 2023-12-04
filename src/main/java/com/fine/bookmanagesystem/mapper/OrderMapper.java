package com.fine.bookmanagesystem.mapper;

import com.fine.bookmanagesystem.model.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    void createOrder(Order order);
}