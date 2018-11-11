package com.example.demo.service;

import com.example.demo.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void saveTest() {
        User user = new User(null, "jimmy", true, 20);
        userService.save(user);
    }

    @Test
    public void savesTest() {
        User tom = new User(null, "tom", true, 18);
        User jerry = new User(null, "jerry", true, 19);
        userService.save(tom, jerry);
    }

    @Test
    public void asyncTest() {
        User user = new User(null, "jimmy", true, 20);
        System.out.println("start ...");
        userService.asyncSave(user);
        System.out.println("执行完毕");
        while (true) {

        }
    }

    @Test
    public void aaaa() {
        User user = new User(null, "jimmy", true, 20);
        userService.aaa(user);
    }
}
