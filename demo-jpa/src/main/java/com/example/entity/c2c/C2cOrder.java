package com.example.entity.c2c;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
public class C2cOrder {
    /**
     * 主键ID
     */
    @Id
    private String id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 交易对象ID
     */
    private Integer targetId;

    /**
     * 订单类型 1购买 0出售
     */
    private Boolean type;

    /**
     * 付款方式 1支付宝 2微信 3银行卡
     */
    private Integer payMode;

    /**
     * 付款凭证: 图片url
     */
    private String payVoucher;

    /**
     * 单价
     */
    private BigDecimal price;

    /**
     * 数量
     */
    private BigDecimal amount;

    /**
     * 总价
     */
    private BigDecimal totalPrice;

    /**
     * 订单状态 1待付款 2待确认 3已取消 4申诉中 5已完成
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 付款时间
     */
    private Date payTime;

    /**
     * 确认时间
     */
    private Date confirmTime;

    /**
     * 取消时间
     */
    private Date cancelTime;

    /**
     * 申诉时间
     */
    private Date appealTime;

    /**
     * 完成时间
     */
    private Date finishTime;
}
