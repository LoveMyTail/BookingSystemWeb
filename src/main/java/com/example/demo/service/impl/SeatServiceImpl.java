package com.example.demo.service.impl;

import com.example.demo.dao.SeatDao;
import com.example.demo.entity.Seat;
import com.example.demo.entity.Show;
import com.example.demo.service.SeatService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SeatServiceImpl implements SeatService {
    @Autowired
    private SeatDao seatDao;
    @Override
    public List<Seat> getSeatById(Integer showId) {
        return seatDao.querySeatById(showId);
    }

    @Transactional
    @Override
    public boolean addSeat(Seat seat) {
        if(seat.getSeatId()!=null && !"".equals(seat.getSeatId())){
            try{
                int effectedNum = seatDao.insertSeat(seat);
                if(effectedNum>0){
                    return true;
                }else{
                    throw new RuntimeException("插入座位信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("插入座位信息失败"+e.getMessage());
            }
        }else{
            throw new RuntimeException("座位信息不能为空！");
        }
    }

    @Override
    public boolean deleteSeat(int seatId) {
        if(seatId>0){
            try{
                int effectedNum = seatDao.deleteSeat(seatId);
                if(effectedNum>0){
                    return true;
                }else{
                    throw new RuntimeException("删除座位信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("删除座位信息失败:"+e.toString());
            }
        }else{
            throw new RuntimeException("座位ID不能为空！");
        }
    }

    @Override
    public boolean modifySeat(Seat seat) {
        if(seat.getSeatId()!=null && seat.getSeatId()>0){
            try{
                //更新区域信息
                int effectedNum = seatDao.updateSeat(seat);
                if(effectedNum>0){
                    return true;
                }
                else{
                    throw new RuntimeException("更新座位信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("更新座位信息失败："+e.toString());
            }
        }else{
            throw new RuntimeException("座位信息不能为空！");
        }
    }

    @Override
    public List<Seat> getSeatIdByCoordinate(Integer coordinateX, Integer coordinateY, Integer showId) {
        return seatDao.querySeatIdByCoordinate(coordinateX,coordinateY,showId);
    }

    @Override
    public PageInfo<Seat> pageQuery(Integer seatId, Integer showId, Integer coordinateX, Integer coordinateY, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Map<String, Object> map = new HashMap<>();
        map.put("seat_id",seatId);
        map.put("show_id",showId);
        map.put("coordinate_x",coordinateX);
        map.put("coordinate_y",coordinateY);
        List<Seat> all = seatDao.findByMap(map);
        return new PageInfo<>(all);
    }
}
