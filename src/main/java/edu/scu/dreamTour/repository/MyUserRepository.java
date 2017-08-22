package edu.scu.dreamTour.repository;

import edu.scu.dreamTour.bean.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: 周秦春
 * @Description: 完成对MyUser的操作
 * @Date: Create in 2017/8/21 15:15
 * @ModifyBy:
 */
public interface MyUserRepository extends JpaRepository<MyUser,Integer>{

}
