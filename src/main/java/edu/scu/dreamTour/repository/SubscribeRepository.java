package edu.scu.dreamTour.repository;

import edu.scu.dreamTour.domain.MyUser;
import edu.scu.dreamTour.domain.Subscribe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

/**
 * @Author: 周秦春
 * @Description: 用于操作用户之间关系的服务类
 * @Date: Create in 2017/9/12 12:49
 * @ModifyBy:
 */
public interface SubscribeRepository extends JpaRepository<Subscribe,Subscribe.SubscribePK>{

    /**
     * 根据传入的关注者账号和被关注者账号查找Subscribe
     * @param subscriberAccount 关注者账号
     * @param account 被关注者账号
     * @return
     */
    Subscribe findBySubscriberAccountAndAccount(String subscriberAccount,String account);

    /**
     * 查找关注account的用户的账号
     * @param account
     * @return
     */
    @Query("select o.subscriberAccount from Subscribe o where o.account = :account order by o.subscribeDate")
    Set<String> findSubscribeAccountByAccount(@Param("account")String account);
}
