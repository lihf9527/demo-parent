package com.example.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public void handler(ConstraintViolationException e) {
        System.out.println("全局异常处理...");
        System.out.println(e.getMessage());
        System.out.println(e.getMessage().split(": ")[1]);
        System.out.println(e.getMessage().split(":")[1]);
        System.out.println(e.getMessage().split(":")[1].trim());
    }

    @ExceptionHandler
    public void handler(Exception e) {
        System.out.println("其他异常...");
    }
}
