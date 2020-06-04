package com.example.demo.dao;

import java.util.Map;

public class OrderSqlProvider {
    public String findByMap(Map<String, Object> map) {

        String re = "select * from orderinfo where 1=1 ";

        Object orderId = map.get("order_id");
        if (orderId != null && !"".equals(orderId)) {
            re += " and order_id like #{order_id}";
        }

        // 根据文章id
        Object userId = map.get("user_id");
        if (userId != null && !"".equals(userId)) {
            re += " and user_id like CONCAT(\"%\",#{user_id},\"%\")";
        }

        Object showId = map.get("show_id");
        if (showId != null && !"".equals(showId)) {
            re += " and show_id = #{show_id}";
        }

        return re;
    }
}
