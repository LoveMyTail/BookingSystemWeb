package com.example.demo.web;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Show;
import com.example.demo.service.AdminService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/superadminadmin")
public class AdminController {
    @Autowired
    private AdminService adminService;


    @RequestMapping(value = "/getadminbyid", method = RequestMethod.GET)
    private Map<String, Object> getAdminById(String adminId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Admin admin = adminService.getAdminById(adminId);
        modelMap.put("admin", admin);
        return modelMap;
    }


    @RequestMapping("/main_admin")
    public String login(String adminID, String password, HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // 验证账号和密码
        // 账号密码正确则登录成功，否则返回首页
        Admin admin = adminService.getAdminById(adminID);
        if (admin == null) {
            // 没有找到，返回管理员登录界面
            request.setAttribute("errorMsg", "该管理员不存在");
            System.out.println(11111);
            response.sendRedirect("/405.jsp");
        } else {

            if (password.equals(admin.getPassword())) {
                request.getSession().setAttribute("admin", admin);
                System.out.println(2222);
                response.sendRedirect("/main_admin.jsp");
            } else {
                request.setAttribute("errorMsg", "管理员密码错误");
                response.sendRedirect("/404.jsp");
            }
        }
        return "redirect:/index.jsp";
    }


}
