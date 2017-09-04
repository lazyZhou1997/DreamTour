package edu.scu.dreamTour.domain.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Author: 周秦春
 * @Description: 用于描述URL资源的类
 * @Date: Create in 2017/9/4 16:49
 * @ModifyBy:
 */
@Entity
public class SysResource {

    /**
     * id，主键
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 资源URL
     */
    @Column(length = 1000)
    private String resourceString;

    /**
     * 资源id
     */
    private String resourceId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 资源名称
     */
    @Column(length = 400)
    private String resourceName;

    /**
     * 资源对应的方法名
     */
    @Column(length = 400)
    private String methodName;

    /**
     * 资源对应的包路径
     */
    @Column(length = 1000)
    private String methodPath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResourceString() {
        return resourceString;
    }

    public void setResourceString(String resourceString) {
        this.resourceString = resourceString;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodPath() {
        return methodPath;
    }

    public void setMethodPath(String methodPath) {
        this.methodPath = methodPath;
    }
}
