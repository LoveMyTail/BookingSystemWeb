package com.example.demo.service.impl;


import com.example.demo.dao.UserDao;
import com.example.demo.entity.Show;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public List<User> getUserList() {
        return userDao.queryUser();
    }

    @Override
    public User getUserById(String userId) {
        return userDao.queryUserById(userId);
    }

    @Transactional
    @Override
    public boolean addUser(User user) {
        if(user.getUserId()!=null && !" ".equals(user.getUserId()) ){
            try{
                int effectedNum = userDao.insertUser(user);
                if(effectedNum>0){
                    return true;
                }
                else{
                    throw new RuntimeException("插入用户信息失败");
                }
            }catch (Exception e) {
                throw new RuntimeException("插入用户信息失败" + e.getMessage());
            }
        }else{
            throw new RuntimeException("用户信息不能为空");
        }
    }

    @Override
    public boolean modifyUser(User user) {
        if(user.getUserId()!=null ){
            try{
                int effectedNum = userDao.updateUser(user);
                if(effectedNum>0){
                    return true;
                }
                else{
                    throw new RuntimeException("更新用户信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("更新用户信息失败："+e.toString());
            }
        }else{
            throw new RuntimeException("用户信息不能为空！");
        }
    }

    @Override
    public boolean deleteUser(String userId) {
        if(userId!=null){
            try{
                int effectedNum = userDao.deleteUser(userId);
                if(effectedNum>0){
                    return true;
                }else{
                    throw new RuntimeException("删除用户信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("删除用户信息失败:"+e.toString());
            }
        }else{
            throw new RuntimeException("用户ID不能为空！");
        }
    }

    @Override
    public PageInfo<User> pageQuery(String userId, String nickname, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Map<String, Object> map = new HashMap<>();
        map.put("user_id",userId);
        map.put("nickname",nickname);
        List<User> all = userDao.findByMap(map);
        return new PageInfo<>(all);
    }
}
