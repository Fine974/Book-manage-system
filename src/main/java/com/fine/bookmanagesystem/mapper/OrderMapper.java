package com.fine.bookmanagesystem.mapper;

import com.fine.bookmanagesystem.model.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {

    // 创建订单
    void createOrder(Order order);

    // 根据用户ID查询订单列表
    List<Order> getOrdersByUserId(@Param("userId") Long userId);

    // 根据订单ID查询订单详情
    Order getOrderById(@Param("orderId") Long orderId);
}
