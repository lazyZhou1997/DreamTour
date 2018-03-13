package edu.scu.dreamTour.service;

import edu.scu.dreamTour.domain.MyUser;
import edu.scu.dreamTour.enums.ExceptionEnum;
import edu.scu.dreamTour.exception.TourDreamException;
import edu.scu.dreamTour.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @Author: 周秦春
 * @Description: 用于处理用户业务逻辑的类
 * @Date: Create in 2017/9/4 20:03
 * @ModifyBy:
 */
@Service
public class MyUserService {

    /**
     * 管理用户数据的类
     */
    @Autowired
    private MyUserRepository myUserRepository;

    /**
     * 密码加密工具类
     */
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

    /**
     * 根据传入的用户账号查找用户类
     * @param account
     * @return
     */
    public MyUser findUserByAccount(String account){
        return myUserRepository.findOne(account);
    }

    /**
     * 注册
     * @param myUser 用户
     */
    @Transactional
    public void register(MyUser myUser){

        //看看用户名是否已经存在
        if (myUserRepository.findOne(myUser.getAccount())!=null){
            //抛出用户名已经存在异常
            throw new TourDreamException(ExceptionEnum.HAS_USER_THIS_ACCOUNT);
        }

        //设置昵称为账号名
        myUser.setNickName(myUser.getAccount());
        //将用户密码加密
        myUser.setPassword(passwordEncoder.encode(myUser.getPassword()));

        //将用户保存到数据库中
        myUserRepository.save(myUser);
    }
}
