package com.example.demo.enums;

public enum Direction implements EnumInfo {
    UP(1, "上"),
    DOWN(3, "下"),
    LEFT(2, "左"),
    RIGHT(4, "右");

    private Integer value;
    private String displayName;

    Direction(Integer value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }
}
