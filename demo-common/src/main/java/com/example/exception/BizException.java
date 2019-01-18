package com.example.exception;

import lombok.Getter;

@Getter
public class BizException extends RuntimeException {
    private int code;

    public BizException(String message) {
        super(message);
    }

    public BizException(String message, int code) {
        super(message);
        this.code = code;
    }
}
