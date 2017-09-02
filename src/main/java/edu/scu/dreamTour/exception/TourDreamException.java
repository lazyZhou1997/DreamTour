package edu.scu.dreamTour.exception;

import edu.scu.dreamTour.enums.ExceptionEnum;

/**
 * @Author: 周秦春
 * @Description:
 * @Date: Create in 2017/8/23 9:16
 * @ModifyBy:
 */
public class TourDreamException extends RuntimeException {

    /**
     * 错误代码
     */
    private Integer code;

    /**
     * 错误信息
     */
    private String message;

    public TourDreamException(ExceptionEnum exceptionEnum) {
        this.message = exceptionEnum.getMessgae();
        this.code = exceptionEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
