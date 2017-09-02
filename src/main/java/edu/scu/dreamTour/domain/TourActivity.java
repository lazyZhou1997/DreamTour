package edu.scu.dreamTour.domain;

import edu.scu.dreamTour.enums.ActivityStatusEnum;
import edu.scu.dreamTour.enums.ActivityTypeEnum;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * @Author: 周秦春
 * @Description: 用于映射到数据库的实体类，表示活动信息
 * @Date: Create in 2017/8/21 11:56
 * @ModifyBy:
 */
@Entity
@org.hibernate.annotations.Table(appliesTo = "tour_activity",comment = "记录旅游活动的表")
public class TourActivity {

    /**
     * 活动id，主键
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 表示活动的当前状态，枚举
     */
    @Column(nullable = false)
    private ActivityStatusEnum activityStatus;

    /**
     *活动举办时间
     */
    private Date holdDate;

    /**
     * 活动创建时间
     */
    private Date createDate;

    /**
     * 活动地点，待定
     */
    // FIXME
    private String address;

    /**
     * 活动内容
     */
    private String content;

    /**
     * 活动类型
     */
    private ActivityTypeEnum activityType;

    /**
     * 活动举办者的引用持有
     */
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "account")
    private MyUser holder;

    /**
     * 持有Participant的集合的引用
     */
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "tourActivities")
    private Set<Participant> participants;

    /**
     * 持有ActivityImage的集合的引用
     */
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Set<ActivityImage> activityImages;

    /**
     * 判断活动是否已经结束
     * @return 如果已经结束，返回true
     */
    public boolean isComplete(){
        //如果成功举办或者取消举办，返回true
        if (activityStatus.equals(ActivityStatusEnum.CANCEL_HOLD)||activityStatus.equals(ActivityStatusEnum.HOLD__SUCCESS)){
            return true;
        }else{//否则返回false
            return false;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ActivityStatusEnum getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(ActivityStatusEnum activityStatus) {
        this.activityStatus = activityStatus;
    }

    public Date getHoldDate() {
        return holdDate;
    }

    public void setHoldDate(Date holdDate) {
        this.holdDate = holdDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Set<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<Participant> participants) {
        this.participants = participants;
    }

    public Set<ActivityImage> getActivityImages() {
        return activityImages;
    }

    public void setActivityImages(Set<ActivityImage> activityImages) {
        this.activityImages = activityImages;
    }

    public MyUser getHolder() {
        return holder;
    }

    public void setHolder(MyUser holder) {
        this.holder = holder;
    }

    public ActivityTypeEnum getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityTypeEnum activityType) {
        this.activityType = activityType;
    }
}


