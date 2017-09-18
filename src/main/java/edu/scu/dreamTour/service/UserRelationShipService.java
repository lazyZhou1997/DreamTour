package edu.scu.dreamTour.service;

import edu.scu.dreamTour.domain.MyUser;
import edu.scu.dreamTour.domain.Subscribe;
import edu.scu.dreamTour.enums.ExceptionEnum;
import edu.scu.dreamTour.exception.TourDreamException;
import edu.scu.dreamTour.repository.MyUserRepository;
import edu.scu.dreamTour.repository.SubscribeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: 周秦春
 * @Description: 处理用户之间相互关系的服务类
 * @Date: Create in 2017/9/12 12:47
 * @ModifyBy:
 */
@Service
public class UserRelationShipService {

    /**
     * 操作用户之间关系的数据库接口
     */
    @Autowired
    private SubscribeRepository subscribeRepository;

    /**
     * 操作用户的数据库接口
     */
    @Autowired
    private MyUserRepository myUserRepository;

    /**
     * 添加一个关注
     * @param subscribe
     */
    public void addUserSubscribe(Subscribe subscribe){

        //判断用户是否已经存在
        if(subscribeRepository.findBySubscriberAccountAndAccount(subscribe.getSubscriberAccount(),subscribe.getAccount())!=null){
            throw new TourDreamException(ExceptionEnum.HAS_SUBSCRIPT);
        }

        //将关注存入数据库
        subscribeRepository.save(subscribe);
    }

    /**
     * 查找指定账号的用户
     * @param account 传入账号
     * @return
     */
    public Set<MyUser> searchMyFans(String account){

        //查找关注者账号
        Set<String> accountStrs = subscribeRepository.findSubscribeAccountByAccount(account);
        //根据用户账号查找粉丝信息，并且忽略粉丝密码等敏感信息
        Set<MyUser> fans = new HashSet<>();//粉丝集合
        MyUser user = new MyUser();//粉丝
        for (String accountStr:
             accountStrs) {
            //查找粉丝信息
            user = myUserRepository.findOne(accountStr);
            //忽略敏感信息
            user.setPassword(null);//隐藏密码
            user.setId_card(null);//隐藏身份证
            user.setRealName(null);//隐藏真实姓名
            user.setTourActivities(null);
            user.setDynamics(null);
            user.setParticipants(null);
            user.setReceiveMessage(null);
            user.setSendedMessages(null);
            user.setSysRoles(null);
            //添加粉丝到集合
            fans.add(user);
        }

        return fans;
    }
}
