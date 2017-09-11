package edu.scu.dreamTour.controller;

import edu.scu.dreamTour.domain.MyUser;
import edu.scu.dreamTour.domain.result.Result;
import edu.scu.dreamTour.enums.ExceptionEnum;
import edu.scu.dreamTour.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 周秦春
 * @Description: 处理登录相关http请求
 * @Date: Create in 2017/9/11 10:29
 * @ModifyBy:
 */
@RestController
public class RegisterController {

    /**
     * 与用户相关的服务类
     */
    @Autowired
    private MyUserService myUserService;

    /**
     * 用户注册
     * @param user 要注册的用户
     * @return
     */
    @PostMapping(value = "/register")
    public Result register(MyUser user){

        myUserService.register(user);

        //构造返回结果
        Result result = new Result();
        result.setCode(ExceptionEnum.SUCCESS.getCode());
        result.setMessage(ExceptionEnum.SUCCESS.getMessgae());

        //不返回用户密码
        user.setPassword(null);
        result.setData(user);

        return result;
    }

}
