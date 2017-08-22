package edu.scu.dreamTour.bean;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author: 周秦春
 * @Description: 用于映射到数据库的实体类，表示为动态点赞
 * @Date: Create in 2017/8/22 9:56
 * @ModifyBy:
 */
@Entity
@org.hibernate.annotations.Table(appliesTo = "thumbs_up",comment = "记录用户点赞信息的表")
public class ThumbsUp implements Serializable{

    /**
     * 点赞人的账号，主键，外键参考MyUser.account
     */
    @Id
    private Integer account;

    /**
     * 点赞的动态ID，主键，外键参考Dynamic.id
     */
    @Id
    private Integer id;

    /**
     * 持有点赞人的引用
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account",unique = true)
    private MyUser user;

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MyUser getUser() {
        return user;
    }

    public void setUser(MyUser user) {
        this.user = user;
    }
}
