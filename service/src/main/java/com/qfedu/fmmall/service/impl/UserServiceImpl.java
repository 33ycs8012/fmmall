package com.qfedu.fmmall.service.impl;

import com.qfedu.fmmall.dao.TestUserDAO;
import com.qfedu.fmmall.entity.TestUser;
import com.qfedu.fmmall.service.UserService;
import com.qfedu.fmmall.vo.ResultVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    TestUserDAO testUserDAO;
    @Override
    public ResultVO checkLogin(String name, String realName) {
        TestUser user = testUserDAO.queryUserByName(name);
        if(user == null) {
            return ResultVO.error(500,"用户名不存在");
        } else {
            //对输入的密码进行加密
            //使用加密后的密码与user中密码进行匹配
            if(user.getRealName().equals(realName)){
                return ResultVO.ok("登录成功");
            } else {
                return ResultVO.error(500,"密码错误");
            }
        }
    }
}
