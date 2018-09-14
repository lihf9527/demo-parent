package com.example.mapper;

import com.example.util.PrintUtils;
import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookMapperTest {
    @Autowired
    private BookMapper bookMapper;

    @Test
    public void findAllTest() {
        bookMapper.findAll().forEach(PrintUtils::println);
    }

    @Test
    public void findByIdTest() {
        val book = bookMapper.findById("8a82819565b2b5cc0165b2b5d00e0000");
        System.out.println(book);
    }

    @Test
    public void deleteById() {
        val id = bookMapper.deleteById("8a82819565b2b5cc0165b2b5d00e0000");
        System.out.println(id);
    }
}
