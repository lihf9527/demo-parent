package com.example.result;

import lombok.Getter;

@Getter
public class Result<T> {
    public static final Result SUCCESS = of(1, "success");

    private int code;
    private String message;
    private T data;

    private static <T> Result<T> of(int code, String message, T data) {
        Result<T> result = new Result<>();
        result.code = code;
        result.message = message;
        result.data = data;
        return result;
    }

    public static <T> Result<T> of(int code, String message) {
        return of(code, message, null);
    }

    public static <T> Result<T> success(T data) {
        return of(1, "success", data);
    }
}
