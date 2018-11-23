package com.example.factory;

import com.example.entity.User;

import java.util.Arrays;
import java.util.List;

public class UserFactory {
    public static User getTom() {
        return new User("Tom", true, 18, "tom@sina.com");
    }

    public static User getJerry() {
        return new User("Jerry", true, 19, "jerry@sina.com");
    }

    public static User getJimmy() {
        return new User("Jimmy", true, 22, "jimmy@sina.com");
    }

    public static User getMaria() {
        return new User("Maria", false, 18, "maria@sina.com");
    }

    public static User getKatelyn() {
        return new User("Katelyn", false, 22, "katelyn@sina.com");
    }

    public static User getAngelia() {
        return new User("Angelia", false, 19, "angelia@sina.com");
    }

    public static List<User> getUsers() {
        return Arrays.asList(getTom(), getJerry(), getJimmy(), getMaria(), getKatelyn(), getAngelia());
    }
}
