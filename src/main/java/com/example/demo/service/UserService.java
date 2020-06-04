package com.example.demo.service;


import com.example.demo.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {
    List<User> getUserList();
    User getUserById(String userId);
    boolean addUser(User user);
    boolean modifyUser(User user);
    boolean deleteUser(String userId);
    PageInfo<User> pageQuery(String userId, String nickname,int pageNum, int pageSize);
}
