package edu.scu.dreamTour.domain;

import org.hibernate.annotations.Table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Author: 周秦春
 * @Description: 用于保存活动图片路径
 * @Date: Create in 2017/8/21 18:22
 * @ModifyBy:
 */
@Entity
@Table(appliesTo = "activity_image",comment = "保存活动图片的表")
public class ActivityImage {


    /**
     * 图片ID，主键
     */
    @Id
    @GeneratedValue
    private Integer imageID;

    /**
     * 活动ID
     */
    private Integer id;

    /**
     * 活动图片路径
     */
    private String imageFile;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }

    public Integer getImageID() {
        return imageID;
    }

    public void setImageID(Integer imageID) {
        this.imageID = imageID;
    }
}
