package edu.scu.dreamTour.controller;

import edu.scu.dreamTour.domain.Participant;
import edu.scu.dreamTour.domain.TourActivity;
import edu.scu.dreamTour.domain.result.Result;
import edu.scu.dreamTour.enums.ExceptionEnum;
import edu.scu.dreamTour.service.TourActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 周秦春
 * @Description: 处理活动相关的请求
 * @Date: Create in 2017/9/12 14:47
 * @ModifyBy:
 */
@RestController
public class ActivityController {

    /**
     * 活动服务类
     */
    @Autowired
    private TourActivityService tourActivityService;

    /**
     * 处理发起活动的http请求
     * @param tourActivity
     * @return
     */
    @PostMapping("/publishActivity")
    public Result publishActivity(TourActivity tourActivity){

        //发起活动
        tourActivityService.launchActivities(tourActivity);
        //构建返回结果
        Result result = new Result(ExceptionEnum.SUCCESS,null);

        return result;
    }

    /**
     * 处理参加活动的http请求
     * @param participant
     * @return
     */
    @PostMapping("/participateActivity")
    public  Result participateActivity(Participant participant){
        //参加活动
        tourActivityService.participateActivity(participant);
        //构建返回结果
        Result result = new Result(ExceptionEnum.SUCCESS,null);

        return  result;
    }

    /**
     * 处理获取所有待举办活动的http请求
     * @param pageIndex 第几个分页
     * @return
     */
    @PostMapping("/getAllActivityWillHold")
    public Result getAllActivityWillHold(int pageIndex){
        //获取第pageIndex分页的所有待举办的活动
        tourActivityService.findAllActivityWillHold(pageIndex);
        //构建返回结果
        Result result = new Result(ExceptionEnum.SUCCESS,null);

        return result;
    }


}
