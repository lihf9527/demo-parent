package com.example.util;

import java.util.Random;

public class RandomUtils {
    private static Random random = new Random();

    private RandomUtils() {
    }

    public static int nextInt(int bound) {
        return random.nextInt(bound);
    }
}
