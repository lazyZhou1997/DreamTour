package edu.scu.dreamTour.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: 周秦春
 * @Description: 用于映射到数据库的实体类，表示发表的动态评论
 * @Date: Create in 2017/8/22 8:18
 * @ModifyBy:
 */
@Entity
@org.hibernate.annotations.Table(appliesTo = "dynamic_comment",comment = "动态的评论")
public class DynamicComment {

    /**
     * 评论ID，主键
     */
    @Id
    @GeneratedValue
    private Integer commentID;

    /**
     * 评论者账号，外键参考MyUser.account
     */
    private String account;

    /**
     * 动态ID，外键参考Dynamic.id
     */
    private Integer id;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 评论时间
     */
    private Date commentDate;

    /**
     * 评论是否被删除
     */
    private boolean commentDelete;

    /**
     * 动态评论者的引用持有
     */
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "account",insertable = false,updatable = false)
    private MyUser myUser;

    public Integer getCommentID() {
        return commentID;
    }

    public void setCommentID(Integer commentID) {
        this.commentID = commentID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public MyUser getMyUser() {
        return myUser;
    }

    public void setMyUser(MyUser myUser) {
        this.myUser = myUser;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public boolean isCommentDelete() {
        return commentDelete;
    }

    public void setCommentDelete(boolean commentDelete) {
        this.commentDelete = commentDelete;
    }
}
