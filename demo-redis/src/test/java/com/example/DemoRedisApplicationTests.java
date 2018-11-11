package com.example;

import com.example.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoRedisApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void contextLoads() {
//        val operations = stringRedisTemplate.opsForValue();
//        operations.set("a", "aaa");
//        User user = new User();
//        user.setName("Tom");
//        user.setSex(true);
//        user.setAddress("深圳");
//        redisTemplate.opsForValue().set("a", user);

        System.out.println(redisTemplate.opsForValue().get("a"));
    }

    @Autowired
    private UserService userService;

    @Value("#{'${names}'.split(',')}")
    private List<String> names;

    @Test
    public void getUserNameTest() {
        System.out.println(userService.getUserName());
        System.out.println(userService.getUserName());
        System.out.println(userService.getUserName());
        names.forEach(System.out::println);
    }
}
