package com.example.controller;

import com.example.exception.BizException;
import org.springframework.core.convert.converter.Converter;

import java.io.File;

public class MyConvert implements Converter<String, Integer> {
    @Override
    public Integer convert(String aDouble) {
        throw new BizException("参数类型不匹配");
    }

    public static void main(String[] args) {
        File root = new File("D:\\IdeaProjects\\BPB");
        remove(root);
    }

    public static void remove(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null && files.length > 0) {
                for (File file1 : files) {
                    remove(file1);
                }
            }
        }
        file.delete();
    }
}
