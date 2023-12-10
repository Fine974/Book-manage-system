package com.fine.bookmanagesystem.mapper;

import com.fine.bookmanagesystem.model.Cart;
import com.fine.bookmanagesystem.model.Order;
import com.fine.bookmanagesystem.model.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {

    // 创建订单
    void createOrder(Order order);

    // 根据用户ID查询订单列表
//    List<Order> getOrdersByUserId(@Param("userId") int userId);
    List<Order> getOrdersByUserId(Integer userId);

    List<Order> getAllOrders();

    // 根据订单ID查询订单详情
    Order getOrderById(@Param("orderId") int orderId);
}
