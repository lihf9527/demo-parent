package com.example.factory;

import com.example.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class UserFactory {

    @Bean
    public User user() {
        User user = new User();
        return user;
    }
}
