package com.qfedu.fmmall.service.impl;

import com.qfedu.fmmall.dao.UserDAO;
import com.qfedu.fmmall.entity.User;
import com.qfedu.fmmall.service.UserService;
import com.qfedu.fmmall.utils.MD5Utils;
import com.qfedu.fmmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Transactional
    public ResultVO userResgit(String name, String pwd) {
        synchronized (this) {
            //1.根据用户查询，这个用户是否已经被注册
            User user = userDAO.queryUserByName(name);

            //2.如果没有被注册则进行保存操作
            if (user == null) {
                String md5Pwd = MD5Utils.md5(pwd);
                user = new User();
                user.setUsername(name);
                user.setPassword(md5Pwd);
                user.setUserImg("img/default.png");
                user.setUserRegtime(new Date());
                user.setUserModtime(new Date());
                int i = userDAO.insertUser(user);
                if (i > 0) {
                    return new ResultVO(10000, "注册成功！", null);
                } else {
                    return new ResultVO(10002, "注册失败！", null);
                }
            } else {
                return new ResultVO(10001, "用户名已经被注册！", null);
            }
        }
    }

    @Override
    public ResultVO checkLogin(String name, String pwd) {
        User user = userDAO.queryUserByName(name);
        if(user == null){
            return new ResultVO(10001,"登录失败，用户名不存在！",null);
        }else{
            String md5Pwd = MD5Utils.md5(pwd);
            if(md5Pwd.equals(user.getPassword())){
                return new ResultVO(10000,"登录成功！",user);
            }else{
                return new ResultVO(10001,"登录失败，密码错误！",null);
            }
        }
    }
}
