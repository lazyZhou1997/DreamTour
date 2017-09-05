package edu.scu.dreamTour.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author: 周秦春
 * @Description: 用于映射到数据库的实体类，表示用户之间的关注关系
 * @Date: Create in 2017/8/22 9:36
 * @ModifyBy:
 */
@Entity
@org.hibernate.annotations.Table(appliesTo = "subscribe",comment = "表示用户之间关注信息的表")
public class Subscribe implements Serializable{

    /**
     * 关注者账号
     */
    @Id
    private String subscriberAccount;

    /**
     * 被关注者
     */
    @Id
    private String account;

    /**
     * 关注日期
     */
    private Date subscribeDate;

    /**
     * 关注者对象持有
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subscriberAccount",unique = true)
    private MyUser subscriber;

    /**
     * 被关注者对象持有
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account",unique = true)
    private MyUser user;

    public String getSubscriberAccount() {
        return subscriberAccount;
    }

    public void setSubscriberAccount(String subscriberAccount) {
        this.subscriberAccount = subscriberAccount;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Date getSubscribeDate() {
        return subscribeDate;
    }

    public void setSubscribeDate(Date subscribeDate) {
        this.subscribeDate = subscribeDate;
    }

    public MyUser getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(MyUser subscriber) {
        this.subscriber = subscriber;
    }

    public MyUser getUser() {
        return user;
    }

    public void setUser(MyUser user) {
        this.user = user;
    }
}
