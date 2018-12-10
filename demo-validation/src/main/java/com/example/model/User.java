package com.example.model;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Data
@Validated
public class User {
    @NotNull
    private String username;

    @NotNull
    private String password;
}
