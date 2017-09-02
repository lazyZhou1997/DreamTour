package edu.scu.dreamTour.repository;

import edu.scu.dreamTour.domain.Dynamic;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: 周秦春
 * @Description: 完成对Dynamic的操作接口
 * @Date: Create in 2017/8/26 10:22
 * @ModifyBy:
 */
public interface DynamicRepository extends JpaRepository<Dynamic,Integer> {
}
