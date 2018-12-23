package com.example.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserForm {
    @NotNull(message = "性别不能为空")
    private Boolean sex;
    private Integer age;
}
