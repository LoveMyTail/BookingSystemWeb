package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class jspController {
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    //@RequestMapping("/")
    public String index(){
        return  "index";
    }
}
