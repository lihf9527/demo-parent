package com.example.entity.c2c;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
public class C2cAdvertisement {
    /**
     * 广告ID
     */
    @Id
    private String id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 类型: 1购买, 0出售
     */
    private Boolean type;

    /**
     * 单价
     */
    private BigDecimal price;

    /**
     * 单笔限额 下限
     */
    private Integer minValue;

    /**
     * 单笔限额 上限
     */
    private Integer maxValue;

    /**
     * 收款方式: 1支付宝 2微信 3银行卡, 用逗号分隔
     */
    private String payModes;

    /**
     * 状态 1上架, 0下架
     */
    private Boolean status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
