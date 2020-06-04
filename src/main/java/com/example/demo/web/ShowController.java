package com.example.demo.web;

import com.example.demo.entity.Show;
import com.example.demo.service.ShowService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//@Controller
@RequestMapping("/superadminshow")
public class ShowController {
    @Autowired
    private ShowService showService;

    @RequestMapping(value = "/listshow", method = RequestMethod.GET)
    private Map<String, Object> listShow() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Show> list = showService.getShowList();
        modelMap.put("showList", list);
        return modelMap;
    }

    @RequestMapping(value = "/getshowbytype", method = RequestMethod.GET)
    private Map<String, Object> getShowByType(String showType) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Show> list = showService.getShowByType(showType);
        modelMap.put("showList", list);
        return modelMap;
    }

    @RequestMapping(value = "/getshowbyname", method = RequestMethod.GET)
    private Map<String, Object> getShowByName(String showName) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Show> list = showService.getShowByName(showName);
        modelMap.put("showList", list);
        return modelMap;
    }


    @RequestMapping(value = "/addshow", method = RequestMethod.POST)
    private Map<String, Object> addShow(@RequestBody Show show) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", showService.addShow(show));
        return modelMap;
    }

    @RequestMapping(value = "/modifyshow", method = RequestMethod.POST)
    private Map<String, Object> modifyShow(@RequestBody Show show) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", showService.modifyShow(show));
        return modelMap;
    }

    @RequestMapping(value = "/removeshow", method = RequestMethod.GET)
    private Map<String, Object> removeShow(Integer showId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", showService.deleteShow(showId));
        return modelMap;
    }


}
