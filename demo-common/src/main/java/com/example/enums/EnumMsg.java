package com.example.enums;

public interface EnumMsg<T> {
    T getValue();

    String getName();

    default boolean isEmpty() {
        return false;
    }
}
