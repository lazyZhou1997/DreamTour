package edu.scu.dreamTour.enums;

/**
 * @Author: 周秦春
 * @Description:
 * @Date: Create in 2017/8/21 16:31
 * @ModifyBy:
 */
public enum JoinStatusEnum {
    WAIT_AUDIT(1,"等待审核"),
    JOIN_SUCCESS(2,"加入成功"),
    ;
    /**
     * 状态码
     */
    private int statusCode;

    /**
     * 状态信息
     */
    private String msg;

    JoinStatusEnum(int statusCode, String msg) {
        this.statusCode = statusCode;
        this.msg = msg;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
