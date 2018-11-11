package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    public static void main(String[] args) {
    }

    private static long calc(int n) {
        if (n < 1) return -1;
        if (n == 1 || n == 2) return 1;
        return calc(n - 1) + calc(n - 2);
    }
}
