package edu.scu.dreamTour.service;

import edu.scu.dreamTour.domain.Message;
import edu.scu.dreamTour.domain.MyUser;
import edu.scu.dreamTour.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

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
    @Transactional
    public void sendMessage(Message message){
        messageRepository.save(message);
    }

    /**
     * 获取传入账号所有未读的消息
     * @param receiverAccount
     */
    @Transactional
    public Set<Message> getAllMessageNotRead(String receiverAccount){

        //构建receiver，接收者
        MyUser receiver = new MyUser();
        receiver.setAccount(receiverAccount);

        //查找该账号下的未读消息
        Set<Message> messages = messageRepository.findByReceiverAndReaded(receiver,false);

        //防止Message与MyUser循环递归产生问题
        for (Message message:
             messages) {
            //消息将发送者与接收者都设置为null
            message.setSender(null);
            message.setReceiver(null);
        }
        return messages;
    }

    /**
     * 将消息的类型设置为已读
     * @param id
     */
    @Transactional
    public void readMessage(Integer id){

        messageRepository.updateMessgaeToReaded(id);

    }
}
