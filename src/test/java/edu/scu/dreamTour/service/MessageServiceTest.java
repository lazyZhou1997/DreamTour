package edu.scu.dreamTour.service;

import edu.scu.dreamTour.domain.Message;
import edu.scu.dreamTour.domain.MyUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @Author: 周秦春
 * @Description:
 * @Date: Create in 2017/9/11 13:15
 * @ModifyBy:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageServiceTest {

    /**
     * 消息服务类
     */
    @Autowired
    private MessageService messageService;

    /**
     * 测试通过
     * @throws Exception
     */
    @Test
    public void sendMessage() throws Exception {
        Message message = new Message();
        message.setSendDate(new Date());
        message.setContent("今晚吃鸡不？");
        MyUser receiveUser = new MyUser();
        receiveUser.setAccount("400");
        message.setReceiver(receiveUser);
        MyUser sendUser = new MyUser();
        sendUser.setAccount("401");
        message.setSender(sendUser);

        messageService.sendMessage(message);
    }

}