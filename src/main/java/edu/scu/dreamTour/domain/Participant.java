package edu.scu.dreamTour.domain;

import edu.scu.dreamTour.domain.IdClass.ParticipantIdClass;
import edu.scu.dreamTour.enums.JoinStatusEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author: 周秦春
 * @Description: 活动参与者在数据库中的映射类
 * @Date: Create in 2017/8/21 16:00
 * @ModifyBy:
 */
@Entity
@IdClass(ParticipantIdClass.class)
@org.hibernate.annotations.Table(appliesTo = "participant",comment = "活动参与者信息表")
public class Participant implements Serializable{

    /**
     *  参与者账号,主键，外键参MyUser.account
     */
    @Id
    @Column(insertable = false,updatable = false)
    private Integer account;

    /**
     * 活动ID，主键，外键参考TourActivity.id
     */
    @Id
    @Column(insertable = false,updatable = false)
    private Integer id;

    /**
     * 申请加入时间
     */
    private Date joinDate;

    /**
     * 参加活动个人介绍信息
     */
    private String personnelIntroduction;

    /**
     * 参与状态
     */
    private JoinStatusEnum joinStatus;

    /**
     * 持有MyUser引用
     */
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "account")
    private MyUser myUser;

    /**
     * 持有TourActivity引用
     */
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private TourActivity tourActivities;

    public Participant(){

    }

    /**
     * 账号相等则返回true
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Participant){

            Participant participant = (Participant) obj;

            if (participant.getAccount().equals(account)){

                return true;

            }else {
                return false;
            }
        }else {
            return false;
        }
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

    public String getPersonnelIntroduction() {
        return personnelIntroduction;
    }

    public void setPersonnelIntroduction(String personnelIntroduction) {
        this.personnelIntroduction = personnelIntroduction;
    }

    @Override
    public int hashCode() {
        return account+id;
    }
}

