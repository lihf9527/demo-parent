package com.example.model;

import com.example.annotation.EnumValue;
import com.example.enums.example.Direction;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class User {
    @NotNull(message = "用户名不能为空")
    private String username;

    @NotNull(message = "密码不能为空")
    private String password;

    @EnumValue(message = "方向枚举值不正确", enumClass = Direction.class)
    private Integer direction;
}
