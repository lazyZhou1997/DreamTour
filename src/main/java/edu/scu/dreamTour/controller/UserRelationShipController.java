package edu.scu.dreamTour.controller;

import edu.scu.dreamTour.domain.MyUser;
import edu.scu.dreamTour.domain.Subscribe;
import edu.scu.dreamTour.domain.result.Result;
import edu.scu.dreamTour.enums.ExceptionEnum;
import edu.scu.dreamTour.service.UserRelationShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @Author: 周秦春
 * @Description: 处理用户之间关系的http请求
 * @Date: Create in 2017/9/12 12:46
 * @ModifyBy:
 */
@RestController
public class UserRelationShipController {

    /**
     * 处理用户之间关系的服务类
     */
    @Autowired
    private UserRelationShipService userRelationShipService;

    /**
     * 处理一次订阅http请求
     * @param subscribe
     * @return
     */
    @PostMapping(value = "/subscribe")
    public Result subscribe(Subscribe subscribe){
        //增加新关注
        userRelationShipService.addUserSubscribe(subscribe);

        //构建返回结果
        return new Result(ExceptionEnum.SUCCESS,null);
    }

    /**
     * 进行一次查找我的粉丝的请求
     * @return
     */
    @GetMapping(value = "/myFans")
    public Result searchMyFans(){
        //获取用户账号
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        String currentAccount = userDetails.getUsername();

        //查找fans
        Set<MyUser> fans = userRelationShipService.searchMyFans(currentAccount);
        //构建返回结果
        Result result = new Result(ExceptionEnum.SUCCESS,fans);

        return result;
    }
}
