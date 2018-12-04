package com.example.entity.c2c;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class C2cPayMode {
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
     * 姓名
     */
    private String name;

    /**
     * 类型 1支付宝 2微信 3银行卡
     */
    private Integer type;

    /**
     * 账号/银行卡号
     */
    private String account;

    /**
     * 二维码
     */
    private String qrCode;

    /**
     * 开户银行
     */
    private String bank;

    /**
     * 开户支行
     */
    private String branchBank;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
