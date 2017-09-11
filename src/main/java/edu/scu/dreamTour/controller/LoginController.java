package edu.scu.dreamTour.controller;

import edu.scu.dreamTour.domain.result.Result;
import edu.scu.dreamTour.enums.ExceptionEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 周秦春
 * @Description: 处理登录相关的http请求
 * @Date: Create in 2017/9/5 10:28
 * @ModifyBy:
 */
@RestController
public class LoginController {

    /**
     * 登录成功的返回结果
     * @return
     */
    @GetMapping(value = "/")
    public Result loginSuccess(){
        Result result = new Result();
        result.setCode(ExceptionEnum.SUCCESS.getCode());
        result.setMessage(ExceptionEnum.SUCCESS.getMessgae());
        return result;

    }

    /**
     * 登录失败的返回结果
     * @return
     */
    @PostMapping(value = "/fail")
    public Result loginFail(){

        Result result = new Result();
        result.setCode(ExceptionEnum.LOGIN_FAIL.getCode());
        result.setMessage(ExceptionEnum.LOGIN_FAIL.getMessgae());
        return result;
    }
}
