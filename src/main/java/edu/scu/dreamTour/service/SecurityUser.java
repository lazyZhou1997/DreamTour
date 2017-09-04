package edu.scu.dreamTour.service;

import edu.scu.dreamTour.domain.MyUser;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @Author: 周秦春
 * @Description: Security使用的User
 * @Date: Create in 2017/9/4 21:36
 * @ModifyBy:
 */
public class SecurityUser extends MyUser implements UserDetails{
    /**
     * 序列化版本号
     */
    private static final long serialVersionUID = 1L;



}
