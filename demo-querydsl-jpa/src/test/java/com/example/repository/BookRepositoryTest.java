package com.example.repository;

import com.example.factory.BookFacotry;
import com.example.model.Book;
import com.example.model.QBook;
import com.example.util.PrintUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Before
    public void init() {
        System.out.println("初始化...");
        for (int i = 0; i < 4; i++) {
            Book book = BookFacotry.generateBook();
            bookRepository.save(book);
        }
        System.out.println("初始化完毕...");
    }

    @Test
    public void findAllTest() {
        bookRepository.findAll(QBook.book.name.eq("西游记")).forEach(PrintUtils::println);
    }

    @Test
    public void countTest() {
        System.out.println(bookRepository.count(QBook.book.name.eq("西游记").or(QBook.book.name.eq("水浒传"))));
    }

    @Test
    public void existsTest() {
        System.out.println(bookRepository.exists(QBook.book.name.eq("三国演义")));
    }
}
