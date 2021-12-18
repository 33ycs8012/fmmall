package com.qfedu.fmmall.dao;

import com.qfedu.fmmall.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO {

    //用户注册
    public int insertUser(User user);

    //根据用户名查询用户信息
    public User queryUserByName(String name);
}
