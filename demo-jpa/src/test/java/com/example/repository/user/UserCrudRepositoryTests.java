package com.example.repository.user;

import com.example.entity.User;
import com.example.factory.UserFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserCrudRepositoryTests {
    @Autowired
    private UserCrudRepository userCrudRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    public void saveTest() {
        User tom = userCrudRepository.save(UserFactory.getTom());
        log.info(tom.toString());

        User user = userRepository.findById(tom.getId()).get();
        log.info(user.toString());

        Assert.assertEquals(tom, user);
    }

    @Test
    @Transactional
    public void saveAllTest() {
        userRepository.deleteAllInBatch();

        List<User> users = UserFactory.getUsers();
        log.info("user.size = " + users.size());

        userCrudRepository.saveAll(users);

        long count = userRepository.count();
        log.info("count = " + count);

        Assert.assertEquals(users.size(), count);
    }

    @Test
    @Transactional
    public void findByIdTest() {
        User jerry = userRepository.save(UserFactory.getJerry());
        log.info("jerry = " + jerry.toString());

        User user = userCrudRepository.findById(jerry.getId()).get();
        log.info("user = " + user.toString());

        Assert.assertEquals(jerry, user);
    }

    @Test
    @Transactional
    public void existsByIdTest() {
        User jimmy = userRepository.save(UserFactory.getJimmy());

        boolean exists = userCrudRepository.existsById(jimmy.getId());
        log.info("exists = " + exists);

        Assert.assertEquals(true, exists);
    }

    @Test
    @Transactional
    public void findAllTest() {
        userRepository.deleteAllInBatch();

        List<User> users = userRepository.saveAll(UserFactory.getUsers());
        log.info("users.size = " + users.size());

        Iterable<User> all = userCrudRepository.findAll();

        List<User> list = new ArrayList();
        all.forEach(list::add);
        log.info("list.size = " + list.size());

        Assert.assertEquals(users.size(), list.size());
    }

    @Test
    @Transactional
    public void findAllByIdTest() {
        List<User> users = userRepository.saveAll(UserFactory.getUsers());
        log.info("users.size = " + users.size());

        List<Integer> ids = users.stream().map(User::getId).collect(Collectors.toList());
        log.info("ids = " + ids);

        Iterable<User> all = userCrudRepository.findAllById(ids);

        List<User> list = new ArrayList<>();
        all.forEach(list::add);
        log.info("list.size = " + list.size());

        Assert.assertEquals(users.size(), list.size());
    }

    @Test
    @Transactional
    public void countTest() {
        userRepository.deleteAllInBatch();

        List<User> users = userRepository.saveAll(UserFactory.getUsers());
        log.info("users.size = " + users.size());

        long count = userCrudRepository.count();
        log.info("count = " + count);

        Assert.assertEquals(users.size(), count);
    }

    @Test
    @Transactional
    public void deleteByIdTest() {
        User katelyn = userRepository.save(UserFactory.getKatelyn());

        Assert.assertEquals(true, userRepository.findById(katelyn.getId()).isPresent());

        userCrudRepository.deleteById(katelyn.getId());

        Assert.assertEquals(false, userRepository.findById(katelyn.getId()).isPresent());
    }

    @Test
    @Transactional
    public void deleteTest() {
        User angelia = userRepository.save(UserFactory.getAngelia());

        Assert.assertEquals(true, userRepository.findById(angelia.getId()).isPresent());

        userCrudRepository.delete(angelia);// 只能删除一条记录, 根据ID删除, 相当于 deleteById

        Assert.assertEquals(false, userRepository.findById(angelia.getId()).isPresent());
    }

    @Test
    @Transactional
    public void deleteAllByIterableTest() {
        userRepository.deleteAllInBatch();

        List<User> users = userRepository.saveAll(UserFactory.getUsers());
        List<User> man = users.stream().filter(User::getSex).collect(Collectors.toList());// 过滤性别为男的所有用户

        userCrudRepository.deleteAll(man);// 根据ID删除, 相当于 deleteAllByIds

        List<User> list = userRepository.findAll().stream().filter(User::getSex).collect(Collectors.toList());
        log.info("list.size = " + list.size());

        Assert.assertEquals(true, list.isEmpty());
    }

    @Test
    @Transactional
    public void deleteAllTest() {
        userRepository.saveAll(UserFactory.getUsers());

        Assert.assertNotEquals(0, userRepository.count());

        userCrudRepository.deleteAll();// 先查出所有记录, 然后根据ID逐条删除

        Assert.assertEquals(0, userRepository.count());
    }
}
