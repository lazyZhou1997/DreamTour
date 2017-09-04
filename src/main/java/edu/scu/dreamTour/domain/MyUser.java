package edu.scu.dreamTour.domain;

import edu.scu.dreamTour.domain.security.SysRole;
import edu.scu.dreamTour.enums.SexEnum;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * @Author: 周秦春
 * @Description: 用于描述用户信息的实体类
 * @Date: Create in 2017/8/21 13:44
 * @ModifyBy:
 */
@Entity
@org.hibernate.annotations.Table(appliesTo = "my_user",comment = "用户信息表")
public class MyUser {

    /**
     * 用户账号，从第1000开始增加，主键
     */
    @Id
    @GeneratedValue
    private Integer account;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 性别，枚举
     */
    private SexEnum sex;

    /**
     * 昵称
     */
    @Column(columnDefinition = "VARCHAR(255) default '默认用户名'")
    private String nickName;

    /**
     * 生日
     */
    private Date birthDay;

    /**
     * 头像存储路径
     */
    private String portraitImageFilePath;

    /**
     * 身份证号码
     */
    @Column(length = 18)
    private String id_card;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号码
     */
    @Length(min=11,max = 11,message = "电话号码长度不正确")
    private String tel_number;

    /**
     * 邮箱
     */
    @Email(message = "邮箱格式不正确")
    private String email;

    /**
     * 是否是志愿者
     */
    private boolean isVolunteer;

    /**
     * 持有Participant的引用
     */
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "myUser")
    private Set<Participant> participants;

    /**
     * 持有对发表的动态集合的引用
     */
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "account")
    private Set<Dynamic> dynamics;

    /**
     * 对举办的活动的集合的持有
     */
    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY,mappedBy = "holder")
    private Set<TourActivity> tourActivities;

    /**
     * 对发送过的消息的集合的持有
     */
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "sender")
    private Set<Message> sendedMessages;

    /**
     * 对接收到的消息的集合的持有
     */
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "receiver")
    private Set<Message> receiveMessage;

    /**
     * 用户角色的集合
     */
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "myUser")
    private Set<SysRole> sysRoles;

    /**
     * 无参构造
     */
    public MyUser(){

    }

    /**
     * 账号相等则返回true
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MyUser){

            MyUser user = (MyUser) obj;

            if (user.getAccount().equals(account)){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getPortraitImageFilePath() {
        return portraitImageFilePath;
    }

    public void setPortraitImageFilePath(String portraitImageFilePath) {
        this.portraitImageFilePath = portraitImageFilePath;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getTel_number() {
        return tel_number;
    }

    public void setTel_number(String tel_number) {
        this.tel_number = tel_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getIsVolunteer() {
        return isVolunteer;
    }

    public void setIsVolunteer(boolean volunteer) {
        isVolunteer = volunteer;
    }

    public Set<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<Participant> participants) {
        this.participants = participants;
    }

    public Set<Dynamic> getDynamics() {
        return dynamics;
    }

    public void setDynamics(Set<Dynamic> dynamics) {
        this.dynamics = dynamics;
    }

    public Set<TourActivity> getTourActivities() {
        return tourActivities;
    }

    public void setTourActivities(Set<TourActivity> tourActivities) {
        this.tourActivities = tourActivities;
    }

    public Set<Message> getSendedMessages() {
        return sendedMessages;
    }

    public void setSendedMessages(Set<Message> sendedMessages) {
        this.sendedMessages = sendedMessages;
    }

    public Set<Message> getReceiveMessage() {
        return receiveMessage;
    }

    public void setReceiveMessage(Set<Message> receiveMessage) {
        this.receiveMessage = receiveMessage;
    }

    public Set<SysRole> getSysRoles() {
        return sysRoles;
    }

    public void setSysRoles(Set<SysRole> sysRoles) {
        this.sysRoles = sysRoles;
    }

    @Override
    public String toString() {
        return "MyUser{" +
                "account=" + account +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", nickName='" + nickName + '\'' +
                ", birthDay=" + birthDay +
                ", portraitImageFilePath='" + portraitImageFilePath + '\'' +
                ", id_card='" + id_card + '\'' +
                ", realName='" + realName + '\'' +
                ", tel_number='" + tel_number + '\'' +
                ", email='" + email + '\'' +
                ", isVolunteer=" + isVolunteer +
                ", participants=" + participants +
                ", dynamics=" + dynamics +
                ", tourActivities=" + tourActivities +
                ", sendedMessages=" + sendedMessages +
                ", receiveMessage=" + receiveMessage +
                '}';
    }
}
