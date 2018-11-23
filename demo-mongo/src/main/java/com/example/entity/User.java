package com.example.entity;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@RequiredArgsConstructor
public class User {
    /**
     * 用户ID
     */
    private String id;

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
