package com.example.exception;

import lombok.Getter;

@Getter
public class BizException extends RuntimeException {
    private int code;

    public BizException(String message) {
        super(message);
    }

    public BizException(int code, String message) {
        super(message);
        this.code = code;
    }
}
