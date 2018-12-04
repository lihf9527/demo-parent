package com.example.entity.c2c;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class C2cAppeal {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 标题
     */
    private String title;

    /**
     * 描述
     */
    private String depict;

    /**
     * 凭证: 图片url
     */
    private String voucher;

    /**
     * 结果 1处理中 2胜诉 3败诉
     */
    private Integer result;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
