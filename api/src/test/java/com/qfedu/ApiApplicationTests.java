package com.qfedu;

import com.qfedu.fmmall.dao.TestUserDAO;
import com.qfedu.fmmall.entity.TestUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ApiApplicationTests {

    @Resource
    TestUserDAO testUserDAO;

    @Test
    void contextLoads() {
        TestUser testUser = testUserDAO.queryUserByName("aa");
        System.out.println("testUser = " + testUser);

    }



}
