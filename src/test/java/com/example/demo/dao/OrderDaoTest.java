package com.example.demo.dao;

import com.example.demo.entity.Order;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDaoTest {
    @Autowired
    private OrderDao orderDao;

    @Test
    @Ignore
    public void queryOrder(){
        List<Order> orderList = orderDao.queryOrder();
        assertEquals(1 ,orderList.size());
    }

    @Test
    @Ignore
    public void queryOrderByShowId(){
        List<Order> orderList = orderDao.queryOrderByShowId(2);
        assertEquals(1 ,orderList.size());
    }

    @Test
    @Ignore
    public void queryOrderByUserId(){
        List<Order> orderList = orderDao.queryOrderByUserId("abc");
        assertEquals(1 ,orderList.size());

    }

    @Test
    @Ignore
    public void queryOrderById(){
        Order order = orderDao.queryOrderById(1);
        assertEquals("abc",order.getUserId());
    }

    @Test

    public void insertOrder(){
        Order order = new Order();
        order.setSeatId(1);
        order.setShowId(1);
        order.setSeatInfo("1排1座");
        order.setUserId("oFe8-5ZI2e5s1yJZdp0GkBDFkXFY");
        int effectedNum = orderDao.insertOrder(order);
        assertEquals(1,effectedNum);
    }

    @Test
    @Ignore
    public void deleteOrder(){
        int effectedNum = orderDao.deleteOrder(2);
        assertEquals(1,effectedNum);
    }
}
