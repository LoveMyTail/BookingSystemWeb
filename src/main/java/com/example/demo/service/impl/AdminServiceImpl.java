package com.example.demo.service.impl;

import com.example.demo.dao.AdminDao;
import com.example.demo.entity.Admin;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin getAdminById(String adminId) {
        Admin admin = null;
        try{
            admin = adminDao.queryAdminById(adminId);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return admin;
//        return adminDao.queryAdminById(adminId);
    }
}
