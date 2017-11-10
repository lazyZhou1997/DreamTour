package edu.scu.dreamTour.controller;

import edu.scu.dreamTour.domain.Message;
import edu.scu.dreamTour.domain.MyUser;
import edu.scu.dreamTour.domain.result.Result;
import edu.scu.dreamTour.enums.ExceptionEnum;
import edu.scu.dreamTour.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

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
    public Result sendMessage(Message message, String receiveAccount, String sendAccount){

        //将消息设置为未读
        message.setReaded(false);

        //封装Message
        //构建receiver
        MyUser receiver = new MyUser();
        receiver.setAccount(receiveAccount);
        //构建sender
        MyUser sender = new MyUser();
        sender.setAccount(sendAccount);
        //添加到Message
        message.setReceiver(receiver);
        message.setSender(sender);

        //保存消息
        messageService.sendMessage(message);

        //构造返回结果
        Result result = new Result(ExceptionEnum.SUCCESS,null);

        return result;
    }

    /**
     * 获取当前用户所有未读消息
     * @return
     */
    @GetMapping(value = "/getMessageNotRead")
    public Result getAllMessageNotRead(){

        //获取当前用户的账号
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        String currentAccount = userDetails.getUsername();

        //查询当前用户的所有未读消息
        Set<Message> messages = messageService.getAllMessageNotRead(currentAccount);

        //构造返回的结果
        Result result = new Result(ExceptionEnum.SUCCESS,messages);

        return result;
    }

    /**
     * 根据消息id将该消息设置为已读
     * @param id 消息id
     * @return
     */
    @PostMapping(value = "/readMessage")
    public Result readMessgae(Integer id){

        //更新消息为已读
        messageService.readMessage(id);

        //构造返回结果
        return new Result(ExceptionEnum.SUCCESS,null);
    }
}
