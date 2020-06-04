package com.example.demo.web;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.Show;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebUserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserDao userDao;


    @RequestMapping("/userList")
    public String list(@RequestParam(name = "user_id", defaultValue = "") String userId,
                       @RequestParam(name = "nickname", defaultValue = "") String nickname,
                       @RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "4") Integer pageSize,
                       Model model) {
        // 获取博主文章的信息
        String user_id = userId;
        if (!"".equals(user_id))
            user_id = "%" + user_id + "%";
        model.addAttribute("user_id", userId);// 将演出编号放到model
        model.addAttribute("nickname", nickname);// 将演出名称放到model
        PageInfo<User> pageData = userService.pageQuery(userId, nickname, pageNum, pageSize);
        // 将数据放到model
        model.addAttribute("pageInfo", pageData);
        System.out.println("--------显示用户信息---------");
        return "user/userList";// 转到演出信息页面展示

    }



    @RequestMapping("/viewUser")
    public String view(String userId, Model model) {
        User user  = userDao.findById(userId);
        model.addAttribute("obj", user);
        return "user/view";// 跳转显示页面
    }
}
