package com.example.demo.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Order {
    /**
     * 订单ID
     */
    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 书籍ID
     */
    private Integer bookId;

    /**
     * 数量
     */
    private Integer amount;

    /**
     * 总价
     */
    private BigDecimal money;
}
