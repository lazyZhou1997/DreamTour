package edu.scu.dreamTour.service;

import edu.scu.dreamTour.domain.Subscribe;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @Author: 周秦春
 * @Description:
 * @Date: Create in 2017/9/12 13:22
 * @ModifyBy:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRelationShipServiceTest {

    @Autowired
    private UserRelationShipService userRelationShipService;

    @Test
    public void addUserSubscribe() throws Exception {
        Subscribe subscribe = new Subscribe();
        subscribe.setAccount("400");
        subscribe.setSubscriberAccount("401");
        subscribe.setSubscribeDate(new Date());

        userRelationShipService.addUserSubscribe(subscribe);

    }

}