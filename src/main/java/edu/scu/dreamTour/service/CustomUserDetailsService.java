package edu.scu.dreamTour.service;

import edu.scu.dreamTour.domain.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @Author: 周秦春
 * @Description: 自制的用户信息处理类
 * @Date: Create in 2017/9/4 20:00
 * @ModifyBy:
 */
public class CustomUserDetailsService implements UserDetailsService{

    /**
     * 处理用户业务逻辑的类
     */
    @Autowired
    private MyUserService myUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //MyUser对应数据库中的用户表，是最终存储用户和密码的表，可自定义
        //本例使用MyUser中的account作为用户名:
        MyUser user = myUserService.findUserByAccount(username);

        //用户没有找到
        if (user == null) {
            throw new UsernameNotFoundException("UserName " + username + " not found");
        }

        // FIXME
        aa
        return null;
    }
}
