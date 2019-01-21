package com.example.util;

import java.io.File;

public class FileUtils {
    private FileUtils() {
    }

    public static void remove(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null && files.length > 0) {
                for (File temp : files) {
                    remove(temp);
                }
            }
        }
        file.delete();
    }
}
