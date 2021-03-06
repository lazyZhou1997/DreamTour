package edu.scu.dreamTour.enums;


/**
 * @Author: 周秦春
 * @Description:
 * @Date: Create in 2017/8/23 9:44
 * @ModifyBy:
 */
public enum ExceptionEnum {
    //与活动相关异常
    HAS_OTHER_TO_HOLD(100,"已经有了其他待举办的活动"),
    HAS_PARTICIPATE_THIS_ACTIVITY(101,"已经申请参加了这个活动"),
    HOLDER_CANT_PARTICIPATE(102,"举办者不能申请参加该活动"),
    //与用户相关异常
    HAS_USER_THIS_ACCOUNT(110,"账户已经被使用"),
    //与用户关系相关异常
    HAS_SUBSCRIPT(120,"已经关注了该用户"),
    //成功
    SUCCESS(200,"成功"),
    LOGIN_FAIL(201,"登录失败"),
    ;
    /**
     * 异常代码
     */
    private Integer code;

    /**
     * 异常信息
     */
    private String messgae;

    ExceptionEnum(Integer code, String messgae) {
        this.code = code;
        this.messgae = messgae;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessgae() {
        return messgae;
    }

    public void setMessgae(String messgae) {
        this.messgae = messgae;
    }
}
