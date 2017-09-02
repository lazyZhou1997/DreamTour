package edu.scu.dreamTour.enums;

/**
 * @Author: 周秦春
 * @Description: 用于定义旅游活动类型的枚举值
 * @Date: Create in 2017/8/24 15:10
 * @ModifyBy:
 */
public enum ActivityTypeEnum {
    CIRY_TOUR(1,"同城游玩"),
    ;

    /**
     * 编号
     */
    private Integer code;

    /**
     * 活动类型
     */
    private String message;

    ActivityTypeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
