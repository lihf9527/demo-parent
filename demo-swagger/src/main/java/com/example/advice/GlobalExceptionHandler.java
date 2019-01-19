package com.example.advice;

import com.example.common.Result;
import com.example.exception.BizException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public Result handler(BindException e) {
        FieldError fieldError = e.getBindingResult().getFieldErrors().get(0);
        if ("typeMismatch".equals(fieldError.getCode()))
            return Result.failure("参数类型不正确", fieldError.getDefaultMessage());

        return Result.failure(fieldError.getDefaultMessage());
    }

    @ExceptionHandler
    public Result handler(BizException e) {
        return Result.of(e.getCode(), e.getMessage());
    }

    @ExceptionHandler
    public Result handler(Exception e) {
        String errorMsg = e + " at " + e.getStackTrace()[0];
        return Result.failure("系统异常", errorMsg);
    }
}
