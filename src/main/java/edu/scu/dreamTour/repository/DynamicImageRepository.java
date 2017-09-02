package edu.scu.dreamTour.repository;

import edu.scu.dreamTour.domain.DynamicImage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: 周秦春
 * @Description: 完成对DynamicImage的操作接口
 * @Date: Create in 2017/8/26 12:40
 * @ModifyBy:
 */
public interface DynamicImageRepository extends JpaRepository<DynamicImage,Integer>{
}
