package com.example;

import com.example.controller.DateConvert;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.convert.support.GenericConversionService;

import javax.annotation.PostConstruct;

@EnableSwagger2Doc
@SpringBootApplication
public class SwaggerApplication {
    @Autowired
    private GenericConversionService conversionService;

    @PostConstruct
    public void init() {
//        conversionService.addConverter(new DateConvert());
    }

    public static void main(String[] args) {
        SpringApplication.run(SwaggerApplication.class, args);
    }
}
