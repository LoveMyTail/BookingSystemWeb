package com.example.demo.dao;


import com.example.demo.entity.User;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    @Ignore
    public void queryUser(){
        List<User> userList = userDao.queryUser();
        assertEquals(0 ,userList.size());
    }

    @Test
    @Ignore
    public void queryUserById(){
        User user = userDao.queryUserById("111111qweqwe");
        assertEquals("测试用例",user.getNickname());
    }

    @Test
    @Ignore
    public void insertUser(){
        User user = new User();
        user.setUserId("111111qweqwe");
        user.setNickname("测试用例");
        int effectedNum= userDao.insertUser(user);
        assertEquals(1,effectedNum);
    }

    @Test
    @Ignore
    public void updateUser(){
        User user = new User();
        user.setUserId("111111qweqwe");
        user.setNickname("又一个测试用例");
        int effectedNum = userDao.updateUser(user);
        assertEquals(1,effectedNum);
    }

    @Test
    @Ignore
    public void deleteUser(){
        int effectedNum = userDao.deleteUser("111111qweqwe");
        assertEquals(1,effectedNum);
    }

}
