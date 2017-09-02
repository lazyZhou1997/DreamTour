package edu.scu.dreamTour.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: 周秦春
 * @Description:
 * @Date: Create in 2017/8/23 22:52
 * @ModifyBy:
 */
@Component
@ConfigurationProperties(prefix = "myProperties")
public class TourDreamProperties {

    /**
     * 分页文件大小
     */
    private Integer pageSize;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
