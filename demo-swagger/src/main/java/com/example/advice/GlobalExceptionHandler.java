package com.example.advice;

import com.example.exception.BizException;
import com.example.result.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public Result handler(ConstraintViolationException e) {
        String message = e.getMessage().split(": ")[1];
        return Result.of(0, message);
    }

    @ExceptionHandler
    public Result handler(BizException e) {
        return Result.of(e.getCode(), e.getMessage());
    }

    @ExceptionHandler
    public Result handler(Exception e) {
        e.printStackTrace();
        return Result.of(-1, "系统异常");
    }
}
