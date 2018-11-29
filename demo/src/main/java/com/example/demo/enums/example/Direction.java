package com.example.demo.enums.example;

import com.example.demo.enums.EnumMsg;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Direction implements EnumMsg<Byte> {
    UP((byte) 1, "上"),
    DOWN((byte) 2, "下"),
    LEFT((byte) 3, "左"),
    RIGHT((byte) 4, "右");

    private Byte value;
    private String name;
}
