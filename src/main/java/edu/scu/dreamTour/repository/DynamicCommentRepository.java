package edu.scu.dreamTour.repository;

import edu.scu.dreamTour.domain.DynamicComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @Author: 周秦春
 * @Description: 完成对DynamicComment的操作接口
 * @Date: Create in 2017/8/26 13:32
 * @ModifyBy:
 */
public interface DynamicCommentRepository extends JpaRepository<DynamicComment,Integer> {
    /**
     * 根据传入的id和dynamicDelete修改commentDelete
     * @param commentDelete
     * @param commentID
     * @return
     */
    @Modifying
    @Query("update DynamicComment o set o.commentDelete = :commentDelete where o.commentID = :commentID")
    void updateCommentDeleteById(@Param("commentDelete")boolean commentDelete,
                                 @Param("commentID")Integer commentID);


}
