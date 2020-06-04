package com.example.demo.service.impl;

import com.example.demo.dao.AreaDao;
import com.example.demo.entity.Area;
import com.example.demo.service.AreaService;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;
    @Override
    public List<Area> getAreaList() {

        return areaDao.queryArea();
    }

    @Override
    public Area getAreaById(int areaId) {

        return areaDao.queryAreaById(areaId);
    }

    @Transactional
    @Override
    public boolean addArea(Area area) {
        if(area.getAreaName()!=null&&!"".equals(area.getAreaName())){
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try{
                int effectedNum = areaDao.insertArea(area);
                if(effectedNum>0){
                    return true;
                }
                else{
                    throw new RuntimeException("插入区域信息失败");
                }

            }catch (Exception e){
                throw new RuntimeException("插入区域信息失败"+e.getMessage());
            }
        }else {
            throw new RuntimeException("区域信息不能为空");
        }

    }

    @Override
    public boolean modifyArea(Area area) {
        if(area.getAreaId()!=null && area.getAreaId()>0){
            area.setLastEditTime(new Date());
            try{
                //更新区域信息
                int effectedNum = areaDao.updateArea(area);
                if(effectedNum>0){
                    return true;
                }
                else{
                    throw new RuntimeException("更新区域信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("更新区域信息失败："+e.toString());
            }
        }else{
            throw new RuntimeException("区域信息不能为空！");
        }
    }

    @Override
    public boolean deleteArea(int areaId) {
        if(areaId>0){
            try{
                int effectedNum = areaDao.deleteArea(areaId);
                if(effectedNum>0){
                    return true;
                }else{
                    throw new RuntimeException("删除区域信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("删除区域信息失败:"+e.toString());
            }
        }else{
            throw new RuntimeException("区域ID不能为空！");
        }
    }
}
