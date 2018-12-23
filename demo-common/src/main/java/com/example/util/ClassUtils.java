package com.example.util;

import java.lang.reflect.ParameterizedType;

public class ClassUtils {
    private ClassUtils() {
    }

    public static <T> T newInstance(Class<T> clazz) {
        try {
            return clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T newGenericInstance(Class clazz, int index) {
        Class<T> genericClass = getGenericClass(clazz, index);
        return newInstance(genericClass);
    }

    public static <T> Class<T> getGenericClass(Class clazz, int index) {
        ParameterizedType pt = (ParameterizedType) clazz.getGenericSuperclass();
        return (Class<T>) pt.getActualTypeArguments()[index];
    }
}
