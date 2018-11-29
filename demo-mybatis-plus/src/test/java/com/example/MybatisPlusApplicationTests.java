package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusApplicationTests {

    @Test
    public void contextLoads() {
    }

    public static void main(String[] args) {
        double num1 = 0.1;
        double num2 = 0.2;
        double num3 = num2 + num1;
        System.out.println(num3);
    }

}
