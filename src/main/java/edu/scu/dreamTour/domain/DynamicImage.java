package edu.scu.dreamTour.domain;

import org.hibernate.annotations.Table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Author: 周秦春
 * @Description:
 * @Date: Create in 2017/8/21 22:43
 * @ModifyBy:
 */
@Entity
@Table(appliesTo = "dynamic_image",comment = "动态中的图片")
public class DynamicImage {

    /**
     * 图片ID，主键
     */
    @Id
    @GeneratedValue
    private Integer imageID;

    /**
     * 动态ID，外键参考Dynamic.id
     */
    private Integer id;

    /**
     * 图片路径
     */
    private String imageFile;

    public Integer getImageID() {
        return imageID;
    }

    public void setImageID(Integer imageID) {
        this.imageID = imageID;
    }

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
}
