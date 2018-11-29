package com.example.demo.enums;

public interface EnumMsg<T> {
    T getValue();

    String getName();

    default boolean isEmpty() {
        return false;
    }
}
