package edu.scu.dreamTour.repository;

import edu.scu.dreamTour.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: 周秦春
 * @Description: 操作消息数据库的接口
 * @Date: Create in 2017/9/11 13:11
 * @ModifyBy:
 */
public interface MessageRepository extends JpaRepository<Message,Integer> {


}
