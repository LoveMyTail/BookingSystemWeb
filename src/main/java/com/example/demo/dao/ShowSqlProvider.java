package com.example.demo.dao;

import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class ShowSqlProvider {

    public String findByMap(Map<String, Object> map) {

        String re = "select * from showinfo where 1=1 ";

        Object showId = map.get("show_id");
        if (showId != null && !"".equals(showId)) {
            re += " and show_id like #{show_id}";
        }

        // 根据文章id
        Object showName = map.get("show_name");
        if (showName != null && !"".equals(showName)) {
            re += " and show_name like CONCAT(\"%\",#{show_name},\"%\")";
        }

        Object showType = map.get("show_type");
        if (showType != null && !"".equals(showType)) {
            re += " and show_type = #{show_type}";
        }

        return re;
    }
}
