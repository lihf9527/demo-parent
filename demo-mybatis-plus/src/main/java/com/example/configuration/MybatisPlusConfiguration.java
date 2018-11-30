package com.example.configuration;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlusConfiguration {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    public static void main(String[] args) {
        System.out.println(calc(20));
        System.out.println(calc(0));
    }

    public static int calc(int month) {
        if (month < 1)
            return -1;// 月份小于0,返回-1
        if (month == 1 || month == 2)
            return 1;// 第一月和第二月都是一对兔子
        return calc(month - 1) + calc(month - 2);// 递归计算兔子
    }
}
