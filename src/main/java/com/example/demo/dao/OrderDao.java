package com.example.demo.dao;

import com.example.demo.entity.Feedback;
import com.example.demo.entity.Order;
import com.example.demo.entity.Show;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

public interface OrderDao {
    List<Order> queryOrder();
    List<Order> queryOrderByUserId(String userId);
    List<Order> queryOrderByShowId(Integer showId);
    Order queryOrderById(Integer orderId);
    int insertOrder(Order order);
    int deleteOrder(int orderId);

    @Mapper
    @SelectProvider(type = OrderSqlProvider.class, method = "findByMap")
    List<Order> findByMap(Map<String, Object> map);

    @Mapper
    @Select("select * from orderinfo where  order_id=#{orderId}")
    public Order findById(Integer orderId);
}
