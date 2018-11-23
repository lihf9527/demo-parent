package com.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class User {
    /**
     * 用户ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 姓名
     */
    @NonNull
    private String name;

    /**
     * 性别
     */
    @NonNull
    private Boolean sex;

    /**
     * 年龄
     */
    @NonNull
    private Integer age;

    /**
     * 邮箱
     */
    @NonNull
    private String email;
}
