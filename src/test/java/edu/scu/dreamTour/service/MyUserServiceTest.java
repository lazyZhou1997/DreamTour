package edu.scu.dreamTour.service;

import edu.scu.dreamTour.domain.MyUser;
import edu.scu.dreamTour.enums.SexEnum;
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
 * @Date: Create in 2017/9/5 13:17
 * @ModifyBy:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MyUserServiceTest {

    /**
     * 用户服务类
     */
    @Autowired
    private MyUserService myUserService;

    @Test
    public void findUserByAccount() throws Exception {

    }

    @Test
    public void register() throws Exception {

        MyUser myUser = new MyUser();
        myUser.setAccount("400");
        myUser.setPassword("123");
        myUser.setBirthDay(new Date());
        myUser.setEmail("929557782@qq.com");
        myUser.setId_card("511112199702086017");
        myUser.setSex(SexEnum.MALE);

        myUserService.register(myUser);
    }

}