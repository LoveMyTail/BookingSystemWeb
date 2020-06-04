package com.example.demo.web;

import com.example.demo.entity.Order;
import com.example.demo.entity.Seat;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController     //=@Controller+@ResponseBody
@RequestMapping("/superadminorder")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/listorder",method = RequestMethod.GET)
    private Map<String, Object> listOrder(){
        Map<String ,Object> modelMap = new HashMap<String, Object>();
        List<Order> list = orderService.getOrderList();
        modelMap.put("orderList",list);
        return modelMap;
    }

    @RequestMapping(value = "/getorderbyshowid",method = RequestMethod.GET)
    private Map<String , Object> getOrderByShowId(Integer showId){
        Map<String ,Object> modelMap = new HashMap<String, Object>();
        List<Order> list = orderService.getOrderByShowId(showId);
        modelMap.put("order",list);
        return modelMap;
    }

    @RequestMapping(value = "/getorderbyuserid",method = RequestMethod.GET)
    private Map<String , Object> getOrderByUserId(String userId){
        Map<String ,Object> modelMap = new HashMap<String, Object>();
        List<Order> list = orderService.getOrderByUserId(userId);
        modelMap.put("order",list);
        return modelMap;
    }

    @RequestMapping(value = "/getorderbyid",method = RequestMethod.GET)
    private Map<String,Object> getOrderId(Integer orderId){
        Map<String ,Object> modelMap = new HashMap<String, Object>();
        Order order = orderService.getOrderById(orderId);
        modelMap.put("order",order);
        return modelMap;
    }

    @RequestMapping(value = "/addorder",method = RequestMethod.POST)
    private Map<String,Object> addOrder(@RequestBody Order order){
        Map<String ,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",orderService.addOrder(order));
        return modelMap;
    }

    @RequestMapping(value = "/removeorder",method = RequestMethod.GET)
    private Map<String,Object> removeOrder(Integer orderId){
        Map<String ,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",orderService.deleteOrder(orderId));
        return modelMap;
    }


}
