package com.example.demo.web;

import com.example.demo.entity.Seat;
import com.example.demo.entity.Show;
import com.example.demo.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/superadminseat")
public class SeatController {
    @Autowired
    private SeatService seatService;

    @RequestMapping(value = "/getseatbyid",method = RequestMethod.GET)
    private Map<String,Object> getSeatById(Integer showId){
        Map<String ,Object> modelMap = new HashMap<String, Object>();
        List<Seat> list = seatService.getSeatById(showId);
        modelMap.put("list",list);
        return modelMap;
    }

    @RequestMapping(value = "/addseat",method = RequestMethod.POST)
    private Map<String, Object> addSeat(@RequestBody Seat seat){
        Map<String ,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",seatService.addSeat(seat));
        return modelMap;
    }

    @RequestMapping(value = "removeseat",method = RequestMethod.GET)
    private Map<String,Object> removeSeat(Integer seatId){
        Map<String ,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",seatService.deleteSeat(seatId));
        return modelMap;
    }

    @RequestMapping(value = "/modifyseat",method = RequestMethod.POST)
    private Map<String,Object> modifySeat(@RequestBody Seat seat) {
        Map<String ,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",seatService.modifySeat(seat));
        return modelMap;
    }

    @RequestMapping(value = "/getseatidbycoordinate",method = RequestMethod.GET)
    private Map<String,Object> getSeatIdByCoordinate(Integer coordinateX,Integer coordinateY,Integer showId){
        Map<String ,Object> modelMap = new HashMap<String, Object>();
        List<Seat> list = seatService.getSeatIdByCoordinate(coordinateX,coordinateY,showId);
        modelMap.put("list",list);
        return modelMap;
    }

}
