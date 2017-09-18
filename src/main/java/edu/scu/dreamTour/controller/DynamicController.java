package edu.scu.dreamTour.controller;

import edu.scu.dreamTour.domain.Dynamic;
import edu.scu.dreamTour.domain.DynamicComment;
import edu.scu.dreamTour.domain.result.Result;
import edu.scu.dreamTour.enums.ExceptionEnum;
import edu.scu.dreamTour.service.DynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 周秦春
 * @Description: 处理动态相关的http请求
 * @Date: Create in 2017/9/12 14:46
 * @ModifyBy:
 */
@RestController
public class DynamicController {

    /**
     * 动态服务类
     */
    @Autowired
    private DynamicService dynamicService;

    /**
     *处理发布动态的http请求
     * @return
     */
    @PostMapping("/publishDynamic")
    public Result publishDynamic(Dynamic dynamic){
        //发布动态
        dynamicService.publishDynamic(dynamic);
        //构建返回结果
        Result result = new Result(ExceptionEnum.SUCCESS,null);

        return result;
    }

    /**
     * 处理评论动态的http请求
     * @param dynamicComment
     * @return
     */
    @PostMapping("/commentDynamic")
    public Result commentDynamic(DynamicComment dynamicComment){
        //动态评论服务
        dynamicService.commentDynamic(dynamicComment);
        //构建返回结果
        Result result = new Result(ExceptionEnum.SUCCESS,null);

        return result;
    }

    /**
     * 处理删除动态的http请求
     * @param id 必须传入已经存在的动态id
     * @return
     */
    @PostMapping("/deleteComment")
    public Result deleteComment(Integer id){
        //删除指定id的动态
        dynamicService.deleteDynamic(id);
        //构建返回结果
        Result result = new Result(ExceptionEnum.SUCCESS,null);

        return result;
    }
    

}
