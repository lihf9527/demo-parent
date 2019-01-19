package com.example.service.impl;

import com.example.service.ExceptionService;
import org.springframework.stereotype.Service;

@Service
public class ExceptionServiceImpl implements ExceptionService {
    @Override
    public void nullPointer() {
        String ss = null;
        ss.length();
    }

    @Override
    public void index() {
        int[] arr = {1, 2};
        System.out.println(arr[2]);
    }

    @Override
    public void number() {
        int a = 10 / 0;
    }
}
