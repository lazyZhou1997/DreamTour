package edu.scu.dreamTour.domain.security;

import edu.scu.dreamTour.domain.MyUser;

import javax.persistence.*;

/**
 * @Author: 周秦春
 * @Description: 用于描述角色的类，映射到数据库中
 * @Date: Create in 2017/9/4 16:47
 * @ModifyBy:
 */
@Entity
public class SysRole {

    /**
     * 用户角色id，主键
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 用户角色名称
     */
    private String name;

    /**
     * 角色对应的用户实体
     */
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "account")
    private MyUser myUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyUser getMyUser() {
        return myUser;
    }

    public void setMyUser(MyUser myUser) {
        this.myUser = myUser;
    }
}
