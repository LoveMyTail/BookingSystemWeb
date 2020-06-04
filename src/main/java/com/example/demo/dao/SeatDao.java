package com.example.demo.dao;

import com.example.demo.entity.Seat;
import com.example.demo.entity.Show;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

public interface SeatDao {
    List<Seat> querySeatById(Integer showId);
    int insertSeat(Seat seat);
    int updateSeat(Seat seat);
    int deleteSeat(int seatId);
    List<Seat>  querySeatIdByCoordinate(Integer coordinateX,int coordinateY,Integer showId );

    @Mapper
    @SelectProvider(type = SeatSqlProvider.class, method = "findByMap")
    List<Seat> findByMap(Map<String, Object> map);

    @Mapper
    @Select("select * from seatinfo where  seat_id=#{seatId}")
    public Seat findById(Integer seatId);

    @Mapper
    @Insert("insert into seatinfo (seat_id,show_id,coordinate_x,coordinate_y,choosen,status) VALUES" +
            " (#{seatId},#{showId},#{coordinateX},#{coordinateY},#{choosen},#{status})")
    public void insert(Seat seat);


    @Select("select count(*) from seatinfo where show_id=#{showId} and coordinate_x=#{coordinateX} and coordinate_y=#{coordinateY}")
    public int countByData(Integer showId,Integer coordinateX,Integer coordinateY);
}
