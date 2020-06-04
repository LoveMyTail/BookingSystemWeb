package com.example.demo.dao;

import com.example.demo.entity.Show;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

public interface ShowDao {
    List<Show> queryShow();
    List<Show> queryShowBySite(String showSite);
    List<Show> queryShowByType(String showType);
    List<Show> queryShowByName(String showName);

    int insertShow(Show show);
    int updateShow(Show show);
    int deleteShow(int showId);

    @Mapper
    @Insert("insert into showinfo (show_id,show_name,show_type,show_site,show_time,show_introduction,total,for_sell,price,img_url) VALUES" +
            "        (#{showId},#{showName},#{showType},#{showSite},#{showTime},#{showIntroduction},#{total},#{forSell},#{price},#{imgUrl})")
    public void insert(Show show);

    @Mapper
    @SelectProvider(type = ShowSqlProvider.class, method = "findByMap")
    List<Show> findByMap(Map<String, Object> map);

    @Mapper
    @Select("select * from showinfo where  show_id=#{showId}")
    public Show findById(Integer showId);

    @Select("select count(*) from showinfo where show_name=#{showName}")
    public int countByShowName(String showName);

}
