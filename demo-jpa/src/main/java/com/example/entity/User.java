package com.example.entity;

import lombok.Data;

@Data
public class User {
    /**
     * 用户ID
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private Boolean sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮箱
     */
    private String email;
}
