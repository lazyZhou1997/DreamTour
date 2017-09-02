package edu.scu.dreamTour.service;

import edu.scu.dreamTour.domain.Dynamic;
import edu.scu.dreamTour.domain.DynamicComment;
import edu.scu.dreamTour.domain.DynamicImage;
import edu.scu.dreamTour.repository.DynamicCommentRepository;
import edu.scu.dreamTour.repository.DynamicImageRepository;
import edu.scu.dreamTour.repository.DynamicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

/**
 * @Author: 周秦春
 * @Description: 用于处理动态和服务相关的服务类
 * @Date: Create in 2017/8/26 10:20
 * @ModifyBy:
 */
@Service
public class DynamicService {

    /**
     * 操作动态的数据库的接口
     */
    @Autowired
    private DynamicRepository dynamicRepository;

    /**
     * 操作动态图片的数据库接口
     */
    @Autowired
    private DynamicImageRepository dynamicImageRepository;

    /**
     * 操作动态评论的数据库接口
     */
    @Autowired
    private DynamicCommentRepository dynamicCommentRepository;

    /**
     * 发布动态，将传入的动态信息保存进入数据库
     *
     * @param dynamic 要保存入数据库的动态信息，包括图片
     */
    @Transactional
    public void publishDynamic(Dynamic dynamic) {

        //保存动态信息
        Dynamic dynamicInDB = dynamicRepository.save(dynamic);

        //保存动态图片
        Set<DynamicImage> dynamicImages = dynamic.getDynamicImages();
        if (dynamicImages != null) {
            for (DynamicImage dynamicImage :
                    dynamicImages) {
                //修改dynamicImage的Id
                dynamicImage.setId(dynamicInDB.getId());
                //保存动态图片
                dynamicImageRepository.save(dynamicImage);
            }
        }

        return;
    }

    /**
     * 评论动态，将要传入的动态评论保存到数据库中
     * @param dynamicComment 要保存入数据库中的动态评论
     */
    @Transactional
    public void commentDynamic(DynamicComment dynamicComment){

        dynamicCommentRepository.save(dynamicComment);

        return;
    }
}
