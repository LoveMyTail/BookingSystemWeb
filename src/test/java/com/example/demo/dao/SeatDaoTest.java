package com.example.demo.dao;

import com.example.demo.entity.Seat;
import com.example.demo.entity.Show;
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
public class SeatDaoTest {
    @Autowired
    private SeatDao seatDao;

    @Test
    public void querySeatById(){
        List<Seat> seatList = seatDao.querySeatById(1);
        assertEquals(7,seatList.size());
    }


    @Test
    @Ignore
    public  void querySeatIdByCoordinate(){
        List<Seat> seatList = seatDao.querySeatIdByCoordinate(5,1,1);
        assertEquals(1,seatList.size());
    }

    @Test
    @Ignore
    public void updateSeat(){
        Seat seat = new Seat();
        seat.setChoosen(true);
        seat.setSeatId(2);
        int effectedNum = seatDao.updateSeat(seat);
        assertEquals(1,effectedNum);

    }
}
