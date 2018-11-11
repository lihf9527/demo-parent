package com.example.demo.util;

import java.lang.reflect.ParameterizedType;

public class ReflectUtils {
    private ReflectUtils() {
    }

    public static <T> T newInstance(Class<T> clazz) {
        T instance = null;
        try {
            instance = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return instance;
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
