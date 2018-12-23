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
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserJpaRepositoryTests {
    @Autowired
    private UserJpaRepository userJpaRepository;
    @Autowired
    private UserRepository userRepository;

    @Before
    public void init() {
        userRepository.deleteAllInBatch();
    }

    @Test
    @Transactional
    public void findAllTest() {
        List<User> users = userRepository.saveAll(UserFactory.getUsers());

        List<User> list = userJpaRepository.findAll();

        Assert.assertEquals(users.size(), list.size());
    }

    @Test
    @Transactional
    public void findAllBySortTest() {
        List<User> users = userRepository.saveAll(UserFactory.getUsers());

        List<User> list = userJpaRepository.findAll(Sort.by(Sort.Order.desc("id")));

        Assert.assertEquals(users.size(), list.size());
        Assert.assertTrue(list.get(0).getId() > list.get(list.size() - 1).getId());
    }

    @Test
    @Transactional
    public void saveAllTest() {
        List<User> users = userJpaRepository.saveAll(UserFactory.getUsers());

        Assert.assertEquals(users.size(), userRepository.count());
    }

    @Test
    public void flushTest() {
        // TODO: 2018/11/23
    }

    @Test
    public void saveAndFlushTest() {
        // TODO: 2018/11/23
    }

    @Test
    @Transactional
    public void deleteInBatchTest() {
        List<User> users = userRepository.saveAll(UserFactory.getUsers());
        List<User> list = users.stream().filter(User::getSex).collect(Collectors.toList());

        userJpaRepository.deleteInBatch(list);

        Assert.assertFalse(userRepository.findAll(QUser.user.sex.isTrue()).iterator().hasNext());
    }

    @Test
    @Transactional
    public void deleteAllInBatchTest() {
        userRepository.saveAll(UserFactory.getUsers());

        Assert.assertNotEquals(0, userRepository.count());

        userJpaRepository.deleteAllInBatch();// 批量删除所有, 相当于 delete form user

        Assert.assertEquals(0, userRepository.count());
    }

    @Test
    @Transactional
    public void getOneTest() {
        User tom = userRepository.save(UserFactory.getTom());
        User user = userJpaRepository.getOne(tom.getId());

        Assert.assertEquals(tom, user);
    }

    @Test
    public void findAllByExampleTest() {

    }

    @Test
    public void findAllByExampleAndSortTest() {

    }
}
