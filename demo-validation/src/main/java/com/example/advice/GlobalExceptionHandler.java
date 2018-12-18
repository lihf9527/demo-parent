package com.example.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public String handler(ConstraintViolationException e) {
        System.out.println("全局异常处理...");
        System.out.println(e.getMessage());
        return e.getMessage().split(": ")[1];
    }

    @ExceptionHandler
    public String handler(Exception e) {
        System.out.println("其他异常...");
        System.out.println(e.getMessage());
        return e.getMessage();
    }
}
