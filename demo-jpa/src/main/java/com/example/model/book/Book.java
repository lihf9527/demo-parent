package com.example.model.book;

import com.example.model.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
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

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", press='" + press + '\'' +
                "} " + super.toString();
    }
}
