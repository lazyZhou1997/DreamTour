package edu.scu.dreamTour.enums;

/**
 * @Author: 周秦春
 * @Description: 用于表示性别的枚举，0表示男，1表示女
 * @Date: Create in 2017/8/21 13:47
 * @ModifyBy:
 */
public enum SexEnum {

    MALE(0,"男"),
    FEMALE(1,"女"),
    ;

    /**
     * 代表数值
     */
    private Integer code;

    /**
     * 代表信息
     */
    private  String msg;

    SexEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "SexEnum{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
