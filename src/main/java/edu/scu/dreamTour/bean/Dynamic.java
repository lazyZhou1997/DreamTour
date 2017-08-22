package edu.scu.dreamTour.bean;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * @Author: 周秦春
 * @Description: 用于映射到数据库的实体类，表示发表的动态
 * @Date: Create in 2017/8/21 22:33
 * @ModifyBy:
 */
@Entity
@org.hibernate.annotations.Table(appliesTo = "dynamic",comment = "发表的动态")
public class Dynamic {

    /**
     * 发表的动态的Id，为主键
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 发表动态的用户，外键关联MyUser.account
     */
    private Integer account;

    /**
     * 表示动态的发表日期
     */
    private Date date;

    /**
     * 表示动态的文字内容
     */
    private String content;

    /**
     * 表示动态中的图片的持有集合
     */
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Set<DynamicImage> dynamicImages;

    /**
     * 动态中评论的集合的引用持有
     */
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Set<DynamicComment> dynamicComments;

    /**
     * 动态中点赞的集合的引用持有
     */
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Set<ThumbsUp> thumbsUps;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Set<DynamicImage> getDynamicImages() {
        return dynamicImages;
    }

    public void setDynamicImages(Set<DynamicImage> dynamicImages) {
        this.dynamicImages = dynamicImages;
    }

    public Set<DynamicComment> getDynamicComments() {
        return dynamicComments;
    }

    public void setDynamicComments(Set<DynamicComment> dynamicComments) {
        this.dynamicComments = dynamicComments;
    }

    public Set<ThumbsUp> getThumbsUps() {
        return thumbsUps;
    }

    public void setThumbsUps(Set<ThumbsUp> thumbsUps) {
        this.thumbsUps = thumbsUps;
    }
}
