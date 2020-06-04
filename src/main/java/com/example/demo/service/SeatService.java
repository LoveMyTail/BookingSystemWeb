package com.example.demo.service;

import com.example.demo.entity.Seat;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SeatService {
    List<Seat> getSeatById(Integer showId);
    boolean addSeat(Seat seat);
    boolean deleteSeat(int seatId);
    boolean modifySeat(Seat seat);
    List<Seat> getSeatIdByCoordinate(Integer coordinateX,Integer coordinateY,Integer showId);
    PageInfo<Seat> pageQuery(Integer seatId,Integer showId, Integer coordinateX,Integer coordinateY, int pageNum, int pageSize);

}
