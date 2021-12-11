package com.qfedu.fmmall.controller;

import com.qfedu.fmmall.service.UserService;
import com.qfedu.fmmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public ResultVO userLogin(@RequestParam String name,@RequestParam String real){
        ResultVO resultVO = userService.checkLogin(name, real);
        return resultVO;
    }
}
