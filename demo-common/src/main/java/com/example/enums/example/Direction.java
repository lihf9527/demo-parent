package com.example.enums.example;

import com.example.enums.EnumMsg;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Direction implements EnumMsg<Integer> {
    UP(1, "上"),
    DOWN(2, "下"),
    LEFT(3, "左"),
    RIGHT(4, "右");

    private Integer value;
    private String name;
}
