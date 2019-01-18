package com.example.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    public static final Result SUCCESS = of(1, "success");

    private int code;
    private String message;
    private T data;

    public static <T> Result<T> of(int code, String message, T data) {
        return new Result<>(code, message, data);
    }

    public static <T> Result<T> of(int code, String message) {
        return of(code, message, null);
    }

    public static <T> Result<T> success(T data) {
        return of(1, "success", data);
    }

    public static <T> Result<T> failure(String message, T data) {
        return of(0, message, data);
    }

    public static <T> Result<T> failure(String message) {
        return failure(message, null);
    }
}
