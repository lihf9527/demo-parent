package com.example.repository.user;

import com.example.entity.User;
import com.example.factory.UserFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserPagingAndSortingRepositoryTests {
    @Autowired
    private UserPagingAndSortingRepository userPagingAndSortingRepository;
    @Autowired
    private UserRepository userRepository;

    @Before
    public void init() {
        userRepository.deleteAllInBatch();
        List<User> list = userRepository.saveAll(UserFactory.getUsers());
        list.forEach(System.out::println);
    }

    @Test
    @Transactional
    public void findAllBySortTest() {
        userPagingAndSortingRepository.findAll(Sort.by("age")).forEach(System.out::println);// age升序
        userPagingAndSortingRepository.findAll(Sort.by(Sort.Order.asc("id"))).forEach(System.out::println);// id升序
        userPagingAndSortingRepository.findAll(Sort.by(Sort.Order.desc("id"))).forEach(System.out::println);// id降序
        userPagingAndSortingRepository.findAll(Sort.by(Sort.Direction.ASC, "id")).forEach(System.out::println);// id升序
        userPagingAndSortingRepository.findAll(Sort.by(Sort.Direction.DESC, "id")).forEach(System.out::println);// id降序
        userPagingAndSortingRepository.findAll(Sort.by(Sort.Direction.DESC, "age", "id")).forEach(System.out::println);// age降序, age相等, 按id降序
        userPagingAndSortingRepository.findAll(Sort.by(Sort.Order.desc("age"), Sort.Order.asc("id"))).forEach(System.out::println);// age降序, age相等, 按id升序
    }

    @Test
    @Transactional
    public void findAllByPageableTest() {
        userPagingAndSortingRepository.findAll(PageRequest.of(1, 2)).forEach(System.out::println);// page从0开始
        userPagingAndSortingRepository.findAll(PageRequest.of(1, 3, Sort.by("age"))).forEach(System.out::println);// age升序, 第二页
        userPagingAndSortingRepository.findAll(PageRequest.of(0, 3, Sort.Direction.DESC, "age")).forEach(System.out::println);// age降序, 第一页
    }
}
