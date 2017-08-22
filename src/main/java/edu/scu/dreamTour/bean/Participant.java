package edu.scu.dreamTour.bean;

import edu.scu.dreamTour.enums.JoinStatusEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * @Author: 周秦春
 * @Description: 活动参与者在数据库中的映射类
 * @Date: Create in 2017/8/21 16:00
 * @ModifyBy:
 */
@Entity
@org.hibernate.annotations.Table(appliesTo = "participant",comment = "活动参与者信息表")
public class Participant implements Serializable{


    /**
     *  参与者账号,主键，外键参yUser.account
     */
    @Id
    private Integer account;

    /**
     * 活动ID，主键，外键参考TourActivity.id
     */
    @Id
    private Integer id;

    /**
     * 加入时间
     */
    private Date joinDate;

    /**
     * 参与状态
     */
    private JoinStatusEnum joinStatus;

    /**
     * 持有MyUser引用
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account",unique = true)
    private MyUser myUser;

    /**
     * 持有TourActivity引用
     */
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private TourActivity tourActivities;

    public Participant(){

    }

    public TourActivity getTourActivities() {
        return tourActivities;
    }

    public void setTourActivities(TourActivity tourActivities) {
        this.tourActivities = tourActivities;
    }

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

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public JoinStatusEnum getJoinStatus() {
        return joinStatus;
    }

    public void setJoinStatus(JoinStatusEnum joinStatus) {
        this.joinStatus = joinStatus;
    }

    public MyUser getMyUser() {
        return myUser;
    }

    public void setMyUser(MyUser myUser) {
        this.myUser = myUser;
    }
}
