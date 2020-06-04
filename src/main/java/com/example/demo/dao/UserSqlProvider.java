package com.example.demo.dao;

import java.util.Map;

public class UserSqlProvider {

    public String findByMap(Map<String, Object> map) {

        String re = "select * from userinfo where 1=1 ";

        Object userId = map.get("user_id");
        if (userId != null && !"".equals(userId)) {
            re += " and user_id like #{user_id}";
            //CONCAT("%",#{show_name},"%")
        }

        // 根据文章id
        Object Nickname = map.get("nickname");
        if (Nickname != null && !"".equals(Nickname)) {
            re += " and nickname like #CONCAT(\"%\",#{nickname},\"%\")";
        }

        return re;
    }
}
