package edu.scu.dreamTour.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

/**
 * @Author: 周秦春
 * @Description:
 * @Date: Create in 2017/9/5 10:28
 * @ModifyBy:
 */
@RestController
public class LoginController {

    @PostMapping(value = "/")
    public String login(){
        return "成功";
    }

    @PostMapping(value = "/register")
    public String register(){

        return "注册";
    }
}
