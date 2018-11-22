package com.example.repository.basic;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudRepositoryTests {

    @Test
    public void saveTest() {
//        userRepository.save(null);
        Assert.assertEquals(1, 1);
    }

    @Test
    public void saveAllTest() {
//        userRepository.saveAll(null);
    }

    @Test
    public void findByIdTest() {
//        userRepository.findById(null);
    }

    @Test
    public void existsByIdTest() {
//        userRepository.existsById(null);
    }

    @Test
    public void findAllTest() {
//        userRepository.findAll();
    }

    @Test
    public void findAllByIdTest() {
//        userRepository.findAllById(null);
    }

    @Test
    public void countTest() {
//        userRepository.count();
    }

    @Test
    public void deleteByIdTest() {
//        userRepository.deleteById(null);
    }

    @Test
    public void deleteTest() {
//        userRepository.delete(null);
    }

    @Test
    public void deleteAllByIterableTest() {
//        userRepository.deleteAll(null);
    }

    @Test
    public void deleteAllTest() {
//        userRepository.deleteAll();
    }
}
