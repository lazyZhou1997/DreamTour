package edu.scu.dreamTour.bean;

import edu.scu.dreamTour.enums.SexEnum;
import edu.scu.dreamTour.repository.MyUserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @Author: 周秦春
 * @Description: 测试MyUser实体类对数据库的映射
 * @Date: Create in 2017/8/21 15:08
 * @ModifyBy:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyUserTest {

    @Autowired
    private MyUserRepository myUserRepository;

    @Test
    public void testInsert(){

        MyUser myUser = new MyUser();
        myUser.setBirthDay(new Date());
        myUser.setEmail("929557782@qq.com");
        myUser.setId_card("511112199702086017");
        myUser.setSex(SexEnum.MALE);
        myUserRepository.save(myUser);

    }

    @Test
    public void testFindOne(){
        MyUser user = myUserRepository.findOne(2);
        System.out.println(user);
    }
}