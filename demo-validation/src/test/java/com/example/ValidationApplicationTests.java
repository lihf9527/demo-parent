package com.example;

import com.example.factory.UserFactory;
import com.example.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidationApplicationTests {

    @Autowired
    private UserFactory userFactory;

    @Test
    public void contextLoads() {
        User user = userFactory.user();
        System.out.println(user);
        System.out.println(user.getUsername());
    }

}
