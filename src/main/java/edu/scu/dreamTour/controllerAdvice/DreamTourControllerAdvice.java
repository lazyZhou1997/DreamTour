package edu.scu.dreamTour.controllerAdvice;

import edu.scu.dreamTour.domain.result.Result;
import edu.scu.dreamTour.exception.TourDreamException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: 周秦春
 * @Description:
 * @Date: Create in 2017/11/11 14:40
 * @ModifyBy:
 */
@ControllerAdvice
public class DreamTourControllerAdvice {

    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = TourDreamException.class)
    @ResponseBody
    public Result defaultErrorHandler(HttpServletRequest req, TourDreamException e) throws Exception {

        //构建异常处理结果
        Result result = new Result();
        result.setCode(e.getCode());
        result.setMessage(e.getMessage());
        result.setData(null);

        //返回异常处理结果
        return result;
    }
}
