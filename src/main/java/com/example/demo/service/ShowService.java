package com.example.demo.service;

import com.example.demo.entity.Show;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ShowService {
    List<Show> getShowList();
    List<Show> getShowByType(String showType);
    List<Show> getShowByName(String showName);
    boolean addShow(Show show);
    boolean modifyShow(Show show);
    boolean deleteShow(int showId);
    PageInfo<Show> pageQuery(Integer showId, String showName, String showType, int pageNum, int pageSize);
}
