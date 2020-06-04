package com.example.demo.dao;

import java.util.Map;

public class SeatSqlProvider {

    public String findByMap(Map<String, Object> map) {

        String re = "select * from seatinfo where 1=1 ";

        Object seatId = map.get("seat_id");
        if (seatId != null && !"".equals(seatId)) {
            re += " and seat_id = #{seat_id}";
        }

        Object showId = map.get("show_id");
        if (showId != null && !"".equals(showId)) {
            re += " and show_id = #{show_id}";
        }
        // 根据文章id
        Object coordinateX = map.get("coordinate_x");
        if (coordinateX != null && !"".equals(coordinateX)) {
            re += " and coordinate_x = #{coordinate_x})";
        }

        Object coordinateY = map.get("coordinate_Y");
        if (coordinateY != null && !"".equals(coordinateY)) {
            re += " and coordinate_Y = #{coordinate_Y}";
        }

        return re;
    }
}
