package com.example.demo.dao;

import com.example.demo.entity.Show;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.jdbc.core.SqlProvider;

import java.util.List;
import java.util.Map;

public interface UserDao {
    List<User> queryUser();
    User queryUserById(String userId);
    int insertUser(User user);
    int updateUser(User user);
    int deleteUser(String userId);

    @Mapper
    @SelectProvider(type = UserSqlProvider.class, method = "findByMap")
    List<User> findByMap(Map<String, Object> map);

    @Mapper
    @Select("select * from userinfo where  user_id=#{userId}")
    User findById(String userId);


}
