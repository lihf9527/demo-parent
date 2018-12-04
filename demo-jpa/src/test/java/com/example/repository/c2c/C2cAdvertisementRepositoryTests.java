package com.example.repository.c2c;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class C2cAdvertisementRepositoryTests {

    @Autowired
    private C2cAdvertisementRepository c2CAdvertisementRepository;

    @Test
    public void test() {
        c2CAdvertisementRepository.findAll();
    }
}
