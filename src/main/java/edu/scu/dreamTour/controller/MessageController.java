package edu.scu.dreamTour.controller;

import edu.scu.dreamTour.domain.Message;
import edu.scu.dreamTour.domain.result.Result;
import edu.scu.dreamTour.enums.ExceptionEnum;
import edu.scu.dreamTour.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 周秦春
 * @Description: 处理用户发送消息相关的http请求
 * @Date: Create in 2017/9/11 13:45
 * @ModifyBy:
 */
@RestController
public class MessageController {
    /**
     * 与用户发送消息相关的服务类
     */
    @Autowired
    private MessageService messageService;

    /**
     * 发送消息
     * @param message
     * @return
     */
    @PostMapping(value = "/sendMessage")
    public Result sendMessage(Message message){

        messageService.sendMessage(message);
        //构造返回结果
        Result result = new Result(ExceptionEnum.SUCCESS,null);

        return result;
    }

    /**
     * 获取所有消息
     */
}
