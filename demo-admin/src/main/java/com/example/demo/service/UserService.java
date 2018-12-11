package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void save(User user1, User user2) {
        user1.setId(null);
        userRepository.save(user1);
        if (true)
            throw new NullPointerException();
        userRepository.save(user2);
    }

    public void aaa(User user) {
        save(user);
        save(user, user);
    }


    @Async
//    @Transactional
    public void asyncSave(User user) {
        System.out.println("async start");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        userRepository.save(user);
        if (true) {
            throw new NullPointerException();
        }
        userRepository.save(user);
        System.out.println("async end");
//        if (user == null)
//            throw new NullPointerException();
//        userRepository.save(user);
    }
}
