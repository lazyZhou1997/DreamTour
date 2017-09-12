package edu.scu.dreamTour.repository;

import edu.scu.dreamTour.domain.Message;
import edu.scu.dreamTour.domain.MyUser;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

/**
 * @Author: 周秦春
 * @Description: 操作消息数据库的接口
 * @Date: Create in 2017/9/11 13:11
 * @ModifyBy:
 */
public interface MessageRepository extends JpaRepository<Message,Integer> {


    /**
     * 传入要查询的接收账号和消息是已读还是未读
     * @param receiver 接收者
     * @param readed 消息已读还是未读
     * @return
     */
    Set<Message> findByReceiverAndReaded(MyUser receiver, boolean readed);

    /**
     * 传入要阅读的消息id，将消息设置为已读
     * @param integer 消息id
     */
    @Modifying
    @Query("update Message o set o.readed = true where o.id = :id")
    void updateMessgaeToReaded(@Param("id")Integer integer);
}
