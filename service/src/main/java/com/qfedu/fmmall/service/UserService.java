package com.qfedu.fmmall.service;

import com.qfedu.fmmall.entity.TestUser;
import com.qfedu.fmmall.vo.ResultVO;

public interface UserService {

    ResultVO checkLogin(String name, String realName);
}
