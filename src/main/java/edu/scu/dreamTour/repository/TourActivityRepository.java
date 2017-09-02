package edu.scu.dreamTour.repository;


import edu.scu.dreamTour.domain.TourActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author: 周秦春
 * @Description: 对TourActivity的操作接口
 * @Date: Create in 2017/8/22 11:48
 * @ModifyBy:
 */
public interface TourActivityRepository extends JpaRepository<TourActivity,Integer> ,JpaSpecificationExecutor<TourActivity> {


}
