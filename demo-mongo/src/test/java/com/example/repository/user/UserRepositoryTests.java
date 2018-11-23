package com.example.repository.user;

import com.example.factory.UserFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    public void test() {
        userRepository.saveAll(UserFactory.getUsers());

        userRepository.findAll().forEach(System.out::println);
    }
}
