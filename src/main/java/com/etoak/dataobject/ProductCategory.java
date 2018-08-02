package com.etoak.dataobject;



import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@DynamicUpdate/* 这个注释是 动态的时间更新 */
/*@Table(name="") 这个注解是 实体与表名不一致的问题 */
@Data
/*Data注解 可以 生成 get 和set 方法  tostring方法*/
public class ProductCategory {
    @Id
    @GeneratedValue/*这个注解是自增的注解 只限定于int类型*/
    private Integer categoryId;


    private String categoryName;

    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
