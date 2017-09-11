package edu.scu.dreamTour.service;

import edu.scu.dreamTour.domain.Message;
import edu.scu.dreamTour.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 周秦春
 * @Description: 用于处理用户之间发送消息
 * @Date: Create in 2017/9/11 11:17
 * @ModifyBy:
 */
@Service
public class MessageService {

    /**
     * 操作消息数据库的接口
     */
    @Autowired
    private MessageRepository messageRepository;

    /**
     * 传入要发送的消息，进行处理后将消息保存到数据库中
     * @param message
     */
    public void sendMessage(Message message){
        messageRepository.save(message);
    }
}
