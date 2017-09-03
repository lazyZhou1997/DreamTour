package edu.scu.dreamTour.service;

import edu.scu.dreamTour.domain.Dynamic;
import edu.scu.dreamTour.domain.DynamicComment;
import edu.scu.dreamTour.domain.DynamicImage;
import edu.scu.dreamTour.repository.DynamicCommentRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * @Author: 周秦春
 * @Description:
 * @Date: Create in 2017/8/26 10:46
 * @ModifyBy:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DynamicServiceTest {

    @Autowired
    private DynamicService dynamicService;

    @Autowired
    private DynamicCommentRepository dynamicCommentRepository;

    /**
     * 测试通过
     * @throws Exception
     */
    @Test
    public void publishDynamic() throws Exception {

        Dynamic dynamic = new Dynamic();
        dynamic.setAccount(1);
        dynamic.setContent("今天去了云南");
        dynamic.setDate(new Date());

        DynamicImage dynamicImage1 = new DynamicImage();
        dynamicImage1.setImageFile("./file云南1.png");

        DynamicImage dynamicImage2 = new DynamicImage();
        dynamicImage2.setImageFile("./file云南2.png");

        Set<DynamicImage> dynamicImages = new HashSet<>();
        dynamicImages.add(dynamicImage1);
        dynamicImages.add(dynamicImage2);
        dynamic.setDynamicImages(dynamicImages);

        dynamicService.publishDynamic(dynamic);
    }

    /**
     * 测试通过
     * @throws Exception
     */
    @Test
    public void commentDynamic() throws Exception {

        DynamicComment dynamicComment = new DynamicComment();
        dynamicComment.setAccount(1);
        dynamicComment.setId(5);
        dynamicComment.setCommentDate(new Date());
        dynamicComment.setContent("幸福啊你");

        dynamicService.commentDynamic(dynamicComment);
    }

    /**
     * 测试通过
     * @throws Exception
     */
    @Test
    public void deleteDynamic() throws Exception {
        dynamicService.deleteDynamic(9);
    }

    /**
     * 测试通过
     * @throws Exception
     */
    @Test
    public void deleteComment() throws Exception {

        dynamicService.deleteComment(1);
        Assert.assertEquals(dynamicCommentRepository.findOne(1).isCommentDelete(),true);
    }
}