package com.example.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class UserModel {
    private Integer id;
    private Boolean sex;
    private Integer age;
    private String email;
    private String nickname;
    private String username;
    private String password;
    private Date createdTime;
    private LocalDate localDate;
    private LocalDateTime localDateTime;
}
