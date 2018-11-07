package com.example.util;

import java.math.BigDecimal;

public class NumberUtils {

    public static void main(String[] args) {

    }

    public static BigDecimal format(BigDecimal number, int scale) {
        return number.setScale(scale, BigDecimal.ROUND_HALF_UP);
    }
}
