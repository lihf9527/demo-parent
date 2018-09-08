package com.example.repository;

import com.example.model.Book;
import com.example.util.PrintUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    public void insertTest() {
        Book book = new Book();
        book.setName("Head First 设计模式");
        book.setAuthor("Eric Freeman");
        book.setPrice(98.0);
        book.setPress("中国电力出版社");
        System.out.println(book);
        bookRepository.save(book);
        System.out.println(book);
    }

    @Test
    public void updateTest() {
        Book book = bookRepository.findById("8a82819565b2b5cc0165b2b5d00e0000").orElseGet(Book::new);
        System.out.println(book);
        book.setAuthor("jimmy");
        bookRepository.save(book);
        System.out.println(book);
    }

    @Test
    public void findByIdTest() {
        Book book = bookRepository.findById("8a82819565b2b5cc0165b2b5d00e0000").orElse(null);
        System.out.println(book);
    }

    @Test
    @Transactional// 需要开启事务, 否则报错
    public void getOneTest() {
        Book book = bookRepository.getOne("8a82819565b2b5cc0165b2b5d00e0000");
        System.out.println(book);
    }

    @Test
    public void findAllTest() {
        // 查询所有
        bookRepository.findAll().forEach(PrintUtils::println);

        // 查询所有并排序
        bookRepository.findAll(Sort.by(Sort.Order.desc("createdTime"))).forEach(PrintUtils::println);

        // 分页查询
        bookRepository.findAll(PageRequest.of(1, 2)).forEach(PrintUtils::println);

        // 分页查询并排序
        bookRepository.findAll(PageRequest.of(1, 2, Sort.Direction.DESC, "createdTime")).forEach(PrintUtils::println);
    }
}
