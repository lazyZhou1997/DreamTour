package edu.scu.dreamTour.domain.IdClass;

import java.io.Serializable;

/**
 * @Author: 周秦春
 * @Description: 活动参与者在数据库中的映射类的Id主键
 * @Date: Create in 2017/8/25 9:24
 * @ModifyBy:
 */
public class ParticipantIdClass implements Serializable {

    /**
     *  参与者账号,主键，外键参yUser.account
     */
    private Integer account;

    /**
     * 活动ID，主键，外键参考TourActivity.id
     */
    private Integer id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParticipantIdClass that = (ParticipantIdClass) o;

        if (!getAccount().equals(that.getAccount())) return false;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        int result = getAccount().hashCode();
        result = 31 * result + getId().hashCode();
        return result;
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
}