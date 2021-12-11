package com.qfedu.fmmall.dao;

import com.qfedu.fmmall.entity.TestUser;

public interface TestUserDAO {

    TestUser queryUserByName(String name);
}
