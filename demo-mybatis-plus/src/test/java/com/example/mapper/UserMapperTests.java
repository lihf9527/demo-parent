package com.example.mapper;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insertTest() {
        User user = new User();
        user.setName("Tom");
        user.setAge(18);
        user.setEmail("tom@sina.com");
        userMapper.insert(user);
    }

    @Test
    public void selectByIdTest() {
        User user = userMapper.selectById(6);
        user.setAge(19);
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.set("name", "Jerry");
        wrapper.eq("id", 6);
        userMapper.update(user, wrapper);
    }

    @Test
    public void selectAllTest() {
        userMapper.selectList(null).forEach(System.out::println);
    }

    @Test
    public void selectPageTest() {
        IPage<User> page = userMapper.selectPage(new Page<>(2, 3), null);
        System.out.println(page.getCurrent());
        System.out.println(page.getPages());
        page.getRecords().forEach(System.out::println);
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
    }
}
