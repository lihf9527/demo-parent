package com.example.demo.util;

import com.example.demo.enums.Direction;
import com.example.demo.enums.EnumInfo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class EnumUtils {
    private static final Map<String, Map<Integer, EnumInfo>> cacheEnumMap = new ConcurrentHashMap<>();

    private EnumUtils() {
    }

    public static <E extends EnumInfo> E toEnum(Class<E> enumClass, Integer value) {
        Map<Integer, EnumInfo> enumInfoMap = Optional.ofNullable(cacheEnumMap.get(enumClass.getName())).orElseGet(() -> getEnumInfoMap(enumClass));
        return enumInfoMap == null ? null : (E) enumInfoMap.get(value);
    }

    public static <E extends EnumInfo> String getDisplayName(Class<E> enumClass, Integer value) {
        E e = toEnum(enumClass, value);
        return e == null ? "" : e.getDisplayName();
    }

    public static <E extends EnumInfo> Map<Integer, EnumInfo> getEnumInfoMap(Class<E> enumClass) {
        Map<Integer, EnumInfo> enumInfoMap = null;
        try {
            Method method = enumClass.getMethod("values");
            EnumInfo[] enumInfos = (EnumInfo[]) method.invoke(null);
            enumInfoMap = Arrays.stream(enumInfos).collect(Collectors.toMap(EnumInfo::getValue, value -> value));
            cacheEnumMap.put(enumClass.getName(), enumInfoMap);
            System.out.println("put ...");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return enumInfoMap;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(toEnum(Direction.class, 3));
        System.out.println(toEnum(Direction.class, 4));
        System.out.println(toEnum(Direction.class, 2));
        System.out.println(getDisplayName(Direction.class, 1));
    }
}
