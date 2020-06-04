package com.example.demo.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    private Map<String,Object> expectedHandler(HttpServletRequest req,Exception e){
        Map<String ,Object> modelMap = new HashMap<String,Object>();
        modelMap.put("success",false);
        modelMap.put("errorMsg",e.getMessage());
        return modelMap;
    };
}
