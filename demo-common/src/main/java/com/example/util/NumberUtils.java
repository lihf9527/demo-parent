package com.example.util;

import java.text.DecimalFormat;

public class NumberUtils {
    private NumberUtils() {
    }

    public static void main(String[] args) {
        System.out.println(new DecimalFormat("#.##").format(34234321.43214));
        System.out.println(new DecimalFormat("00.00").format(1.43214));
        System.out.println(new DecimalFormat("##.00").format(1.43214));
        System.out.println(new DecimalFormat("#.##%").format(0.54576));
        System.out.println(new DecimalFormat("#.00%").format(0.54576));
    }
}
