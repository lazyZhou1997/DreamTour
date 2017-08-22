package edu.scu.dreamTour.bean;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: 周秦春
 * @Description: 用于映射到数据库的实体类，表示为消息的发送
 * @Date: Create in 2017/8/22 10:08
 * @ModifyBy:
 */
@Entity
@org.hibernate.annotations.Table(appliesTo = "message",comment = "消息列表")
public class Message {

    /**
     * 消息ID，主键，自动增长
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 消息的发送时间
     */
    private Date sendDate;

    /**
     * 消息内容
     */
    private String content;

    /**
     * 消息发送者对象引用持有
     */
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "sendAccount",referencedColumnName = "account")
    private MyUser sender;

    /**
     * 消息接受者对象引用持有
     */
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "receiveAccount",referencedColumnName = "account")
    private MyUser receiver;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MyUser getSender() {
        return sender;
    }

    public void setSender(MyUser sender) {
        this.sender = sender;
    }

    public MyUser getReceiver() {
        return receiver;
    }

    public void setReceiver(MyUser receiver) {
        this.receiver = receiver;
    }
}
