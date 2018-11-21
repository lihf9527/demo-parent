package com.example.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
public class Book extends BaseEntity {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(length = 32)
    private String id;

    /**
     * 书名
     */
    @Column(nullable = false)
    private String name;

    /**
     * 作者
     */
    @Column(nullable = false)
    private String author;

    /**
     * 价格
     */
    @Column(nullable = false)
    private Double price;

    /**
     * 出版社
     */
    @Column(nullable = false)
    private String press;
}
