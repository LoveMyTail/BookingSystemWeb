package com.example.demo.service;

import com.example.demo.entity.Feedback;
import com.example.demo.entity.Order;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface OrderService {
    List<Order> getOrderList();
    List<Order> getOrderByShowId(Integer showId);
    List<Order> getOrderByUserId(String userId);
    Order getOrderById(Integer orderId);
    boolean addOrder(Order order);
    boolean deleteOrder(Integer orderId);
    PageInfo<Order> pageQuery(Integer orderId, String userId, Integer showId, int pageNum, int pageSize);
}
