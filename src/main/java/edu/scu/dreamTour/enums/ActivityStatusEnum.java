package edu.scu.dreamTour.enums;

import sun.reflect.generics.repository.GenericDeclRepository;

/**
 * @Author: 周秦春
 * @Description: 用于描述当前活动所处状态，分别有等待审核、等待举办、取消举办、正在举办、成功举办
 * @Date: Create in 2017/8/21 13:18
 * @ModifyBy:
 */
public enum ActivityStatusEnum {

    AUDITING(1,"等待审核"),
    WAIT_HOLD(2,"等待举办"),
    CANCEL_HOLD(3,"取消举办"),
    HOLDING(4,"正在举办"),
    HOLD__SUCCESS(5,"成功举办")
    ;

    /**
     * 活动状态码
     */
    private Integer statusCode;

    /**
     * 活动状态名
     */
    private  String name;

    ActivityStatusEnum(Integer statusCode, String name) {
        this.statusCode = statusCode;
        this.name = name;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
