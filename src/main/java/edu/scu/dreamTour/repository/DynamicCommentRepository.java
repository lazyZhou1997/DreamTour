package edu.scu.dreamTour.repository;

import edu.scu.dreamTour.domain.DynamicComment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: 周秦春
 * @Description: 完成对DynamicComment的操作接口
 * @Date: Create in 2017/8/26 13:32
 * @ModifyBy:
 */
public interface DynamicCommentRepository extends JpaRepository<DynamicComment,Integer> {
}
