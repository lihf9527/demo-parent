package com.example.util;

import java.util.Arrays;
import java.util.List;

public class PrintUtils {
    private PrintUtils() {
    }

    public static void print(Object object) {
        System.out.println(object);
    }

    public static void println() {
        System.out.println();
    }

    public static void println(Object object) {
        System.out.println(object);
    }

    public static void forEachPrintln(Iterable iterable) {
        iterable.forEach(System.out::println);
    }

    public static void main(String[] args) {
        print(1);
        print(2);
        print(3);

        println();

        println(123456);
        println(Math.PI);
        println("Hello World!");

        println();

        List<String> list = Arrays.asList("tom", "jerry", "jimmy");
        forEachPrintln(list);
        println();
        list.forEach(PrintUtils::println);
    }
}
