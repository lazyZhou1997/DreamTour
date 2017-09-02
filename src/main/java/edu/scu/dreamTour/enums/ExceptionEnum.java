package edu.scu.dreamTour.enums;

/**
 * @Author: 周秦春
 * @Description:
 * @Date: Create in 2017/8/23 9:44
 * @ModifyBy:
 */
public enum ExceptionEnum {
    //成功
    SUCCESS(200,"成功"),
    //与活动相关异常
    HAS_OTHER_TO_HOLD(100,"已经有了其他待举办的活动"),
    HAS_PARTICIPATE_THIS_ACTIVITY(101,"已经申请参加了这个活动"),
    HOLDER_CANT_PARTICIPATE(102,"举办者不能申请参加该活动"),
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
