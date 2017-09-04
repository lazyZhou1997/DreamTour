package edu.scu.dreamTour.domain.security;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Author: 周秦春
 * @Description: 用于描述URL资源对应的角色的类
 * @Date: Create in 2017/9/4 16:50
 * @ModifyBy:
 */
@Entity
public class SysResourceRole {

    /**
     * 资源角色id，主键
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 角色id
     */
    private String roleid;

    /**
     * 资源Id
     */
    private String resourceId;

    /**
     * 更新时间
     */
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
