package com.example.repository.user;

import com.example.entity.QUser;
import com.example.entity.User;
import com.example.factory.UserFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {
    @Autowired
    private UserRepository userRepository;

    @Before
    public void init() {
        userRepository.deleteAll();
    }

    @Test
    public void insertTest() {
        User tom = userRepository.insert(UserFactory.getTom());
        Optional<User> optional = userRepository.findById(tom.getId());
        Assert.assertTrue(optional.isPresent());
        Assert.assertEquals(tom, optional.get());
    }

    @Test
    public void insertAllTest() {
        List<User> users = userRepository.insert(UserFactory.getUsers());
        users.forEach(System.out::println);
        Assert.assertEquals(users.size(), userRepository.count());
    }

    @Test
    public void saveTest() {
        User tom = userRepository.save(UserFactory.getTom());
        Optional<User> optional = userRepository.findById(tom.getId());
        Assert.assertTrue(optional.isPresent());
        Assert.assertEquals(tom, optional.get());

        tom.setName("Tommy");
        userRepository.save(tom);
        Optional<User> optional1 = userRepository.findById(tom.getId());
        Assert.assertTrue(optional1.isPresent());
        Assert.assertEquals("Tommy", optional1.get().getName());
    }

    @Test
    public void saveAllTest() {
        List<User> users = userRepository.saveAll(UserFactory.getUsers());
        users.forEach(System.out::println);
        Assert.assertEquals(users.size(), userRepository.count());
    }

    @Test
    public void deleteByIdTest() {
        User jerry = userRepository.save(UserFactory.getJerry());
        userRepository.deleteById(jerry.getId());
        Optional<User> optional = userRepository.findById(jerry.getId());
        Assert.assertFalse(optional.isPresent());
    }

    @Test
    public void deleteAllByIds() {
        List<User> users = userRepository.saveAll(UserFactory.getUsers());
        userRepository.deleteAll(users);
        Assert.assertEquals(0, userRepository.count());
    }

    @Test
    public void deleteAllTest() {
        List<User> users = userRepository.saveAll(UserFactory.getUsers());
        Assert.assertEquals(users.size(), userRepository.count());
        userRepository.deleteAll();
        Assert.assertEquals(0, userRepository.count());
    }

    @Test
    public void countTest() {
        List<User> users = userRepository.saveAll(UserFactory.getUsers());
        Assert.assertEquals(users.size(), userRepository.count());
    }

    @Test
    public void countByPredicate() {
        List<User> users = userRepository.saveAll(UserFactory.getUsers());
        long count = users.stream().filter(User::getSex).count();
        long count1 = userRepository.count(QUser.user.sex.isTrue());
        Assert.assertEquals(count, count1);
    }

    @Test
    public void existsByIdTest() {
        User tom = userRepository.insert(UserFactory.getTom());
        boolean exists = userRepository.existsById(tom.getId());
        Assert.assertTrue(exists);
    }

    @Test
    public void existsByPredicate() {
        userRepository.insert(UserFactory.getUsers());
        boolean exists = userRepository.exists(QUser.user.age.goe(26));
        Assert.assertFalse(exists);
    }

    @Test
    public void findAllTest() {
        userRepository.insert(UserFactory.getUsers());
        userRepository.findAll(QUser.user.name.contains("Tom")).forEach(System.out::println);
        userRepository.findAll(QUser.user.name.containsIgnoreCase("tom")).forEach(System.out::println);
        Page<User> page = userRepository.findAll(PageRequest.of(1, 2, Sort.by("age")));
        System.out.println(page.getSize());
        System.out.println(page.getNumber());
    }
}
