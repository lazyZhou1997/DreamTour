package edu.scu.dreamTour.utils;

import edu.scu.dreamTour.domain.TourActivity;
import edu.scu.dreamTour.domain.result.PageResult;
import org.springframework.data.domain.Page;

/**
 * @Author: 周秦春
 * @Description: 传入Page之后构造出一个自己的PageResult
 * @Date: Create in 2017/8/24 14:44
 * @ModifyBy:
 */
public class PageResultUtils {

    /**
     * 传入page之后根据其中信息获取一个PageResult对象
     * @param page Page对象，包饭分页信息
     * @return
     */
    public static PageResult getTourActivityPageResult(Page<TourActivity> page){

        //获取一个PageResult的对象
        PageResult<TourActivity> pageResult = new PageResult<TourActivity>();
        //更具page中的信息设置pageResult中的信息
        pageResult.setContent(page.getContent());
        pageResult.setNumber(page.getNumber()+1);
        pageResult.setNumberOfElements(page.getNumberOfElements());
        pageResult.setTotalElements(page.getTotalElements());
        pageResult.setTotalPages(page.getTotalPages());

        return pageResult;
    }
}
