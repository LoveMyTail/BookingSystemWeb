package com.example.demo.web;


import com.example.demo.entity.Feedback;
import com.example.demo.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/superadminfeedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @RequestMapping(value = "/listfeedback",method = RequestMethod.GET)
    private Map<String,Object> listFeedback(){
        Map<String ,Object> modelMap = new HashMap<String, Object>();
        List<Feedback> list = feedbackService.getFeedbackList();
        modelMap.put("feedbackList",list);
        return modelMap;
    }

    @RequestMapping(value = "/getfeedbackbyuserid",method = RequestMethod.GET)
    private Map<String , Object> getFeedbackByUserId(String userId){
        Map<String ,Object> modelMap = new HashMap<String, Object>();
        List<Feedback> list = feedbackService.getFeedbackByUserId( userId);
        modelMap.put("feedbackList",list);
        return modelMap;
    }

    @RequestMapping(value = "/addfeedback",method = RequestMethod.POST)
    private Map<String,Object> addFeedback(@RequestBody Feedback feedback){
        Map<String ,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",feedbackService.addFeedback(feedback));
        return modelMap;
    }

    @RequestMapping(value = "/removefeedback",method = RequestMethod.GET)
    private Map<String,Object> removeFeedback(Integer feedbackId){
        Map<String ,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",feedbackService.deleteFeedback(feedbackId));
        return modelMap;
    }
}
