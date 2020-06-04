package com.example.demo.service.impl;

import com.example.demo.dao.OrderDao;
import com.example.demo.entity.Feedback;
import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Order> getOrderList() {
        return orderDao.queryOrder();
    }

    @Override
    public List<Order> getOrderByShowId(Integer showId) {
        return orderDao.queryOrderByShowId(showId);
    }

    @Override
    public List<Order> getOrderByUserId(String userId) {
        return orderDao.queryOrderByUserId(userId);
    }

    @Override
    public Order getOrderById(Integer orderId) {
        return orderDao.queryOrderById(orderId);
    }

    @Override
    public boolean addOrder(Order order) {
        if(order.getSeatId()!=null && !" ".equals(order.getSeatId()) ){
            try{
                int effectedNum = orderDao.insertOrder(order);
                if(effectedNum>0){
                    return true;
                }
                else{
                    throw new RuntimeException("插入订单信息失败");
                }
            }catch (Exception e) {
                throw new RuntimeException("插入订单信息失败" + e.getMessage());
            }
        }else{
            throw new RuntimeException("订单信息不能为空");
        }
    }

    @Override
    public boolean deleteOrder(Integer orderId) {
        if(orderId!=null){
            try{
                int effectedNum = orderDao.deleteOrder(orderId);
                if(effectedNum>0){
                    return true;
                }else{
                    throw new RuntimeException("删除订单信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("删除订单信息失败:"+e.toString());
            }
        }else{
            throw new RuntimeException("订单ID不能为空！");
        }
    }

    @Override
    public PageInfo<Order> pageQuery(Integer orderId, String userId, Integer showId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Map<String, Object> map = new HashMap<>();
        map.put("order_id",orderId);
        map.put("user_id",userId);
        map.put("show_id",showId);
        List<Order> all = orderDao.findByMap(map);
        return new PageInfo<>(all);
    }
}
