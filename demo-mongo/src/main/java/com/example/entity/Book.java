package com.example.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Book {
    /**
     * 书籍ID
     */
    private Integer id;

    /**
     * 书籍名
     */
    private String name;

    /**
     * 作者
     */
    private String author;

    /**
     * 单价
     */
    private BigDecimal price;

    /**
     * 出版社
     */
    private String press;
}
