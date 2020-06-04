package com.example.demo.service.impl;

import com.example.demo.dao.ShowDao;
import com.example.demo.entity.Show;
import com.example.demo.service.ShowService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShowServiceImpl implements ShowService {
    @Autowired
    private ShowDao showDao;
    @Override
    public List<Show> getShowList() {

        return showDao.queryShow();
    }

    @Override
    public List<Show> getShowByType(String showType) {
        return showDao.queryShowByType(showType);
    }

    @Override
    public List<Show> getShowByName(String showName) {
        return showDao.queryShowByName(showName);
    }


    @Transactional
    @Override
    public boolean addShow(Show show) {
        if(show.getShowName()!=null&&!"".equals(show.getShowName())){
            try{
                int effectedNum = showDao.insertShow(show);
                if(effectedNum>0){
                    return true;
                }else{
                    throw new RuntimeException("插入信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("插入信息失败"+e.getMessage());
            }
        }else{
            throw new RuntimeException("信息不能为空！");
        }
    }

    @Override
    public boolean modifyShow(Show show) {
        if(show.getShowId()!=null && show.getShowId()>0){
            try{
                //更新区域信息
                int effectedNum = showDao.updateShow(show);
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
    public boolean deleteShow(int showId) {
        if(showId>0){
            try{
                int effectedNum = showDao.deleteShow(showId);
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

    @Override
    public PageInfo<Show> pageQuery(Integer showId, String showName, String showType, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Map<String, Object> map = new HashMap<>();
        map.put("show_id",showId);
        map.put("show_name",showName);
        map.put("show_type",showType);
        List<Show> all = showDao.findByMap(map);
        return new PageInfo<>(all);
    }


}
