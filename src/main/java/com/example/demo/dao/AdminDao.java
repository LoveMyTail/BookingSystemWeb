package com.example.demo.dao;

import com.example.demo.entity.Admin;

public interface AdminDao {
    Admin queryAdminById(String adminId);
}
