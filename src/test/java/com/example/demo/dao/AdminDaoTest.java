package com.example.demo.dao;

import com.example.demo.entity.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminDaoTest {
    @Autowired
    private AdminDao adminDao;

    @Test
    public void queryAdminById(){
        Admin admin = adminDao.queryAdminById("qwer");
        assertEquals("password",admin.getPassword());
    }
}
