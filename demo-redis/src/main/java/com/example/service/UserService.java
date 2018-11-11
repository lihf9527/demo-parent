package com.example.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Cacheable("name")
    public String getUserName() {
        System.out.println("Tom ...");
        return "Tom";
    }
}
