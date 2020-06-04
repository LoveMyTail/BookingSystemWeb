package com.example.demo.dao;

import com.example.demo.entity.Area;

import java.util.List;

public interface AreaDao {
    List<Area> queryArea();    //一次返回所有Area信息
    Area queryAreaById (int areaId);           //根据单条信息做查询
    /**
     *  列出区域列表
     * @param area
     * @return
     */
    int insertArea(Area area);
    /**
     * 插入区域信息
     * @param area
     * @return
     */

    int updateArea(Area area);
    /**
     *更新区域信息
     * @param area
     * @return
     */
    int deleteArea(int areaId);
    /**
     *
     *删除区域信息
     *
     * @param areaId
     * @return
     */

}
