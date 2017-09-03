package edu.scu.dreamTour.repository;

import edu.scu.dreamTour.domain.Dynamic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @Author: 周秦春
 * @Description: 完成对Dynamic的操作接口
 * @Date: Create in 2017/8/26 10:22
 * @ModifyBy:
 */
public interface DynamicRepository extends JpaRepository<Dynamic,Integer> {

    /**
     * 根据传入的id和dynamicDelete修改dynamicDelete
     * @param dynamicDelete
     * @param id
     * @return
     */
    @Modifying
    @Query("update Dynamic o set o.dynamicDelete = :dynamicDelete where o.id = :id")
    void updateDynamicDeleteById(@Param("dynamicDelete")boolean dynamicDelete,
                                           @Param("id")Integer id);
}
