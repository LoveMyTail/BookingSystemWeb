package com.example.demo.web;

import com.example.demo.entity.Area;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController     //=@Controller+@ResponseBody
@RequestMapping("/superadminuser")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/listuser",method = RequestMethod.GET)
    private Map<String ,Object> listUser(){
        Map<String ,Object> modelMap = new HashMap<String, Object>();
        List<User> list = userService.getUserList();
        modelMap.put("userList",list);
        return modelMap;
    }

    @RequestMapping(value = "/getuserbyid",method = RequestMethod.GET)
    private Map<String,Object> getUserById(String userId){
        Map<String ,Object> modelMap = new HashMap<String, Object>();
        User user = userService.getUserById(userId);
        modelMap.put("user",user);
        return modelMap;
    }

    @RequestMapping(value = "/adduser",method = RequestMethod.POST)
    private Map<String,Object> addUser(@RequestBody User user){
        Map<String ,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",userService.addUser(user));
        return modelMap;
    }




    @RequestMapping(value = "/modifyuser",method = RequestMethod.POST)
    private Map<String,Object> modifyArea(@RequestBody User user) {
        Map<String ,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",userService.modifyUser(user));
        return modelMap;
    }


    @RequestMapping(value = "/removeuser",method = RequestMethod.GET)
    private Map<String,Object> removeUser(String userId){
        Map<String ,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",userService.deleteUser(userId));
        return modelMap;
    }
}
