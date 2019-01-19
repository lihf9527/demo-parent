package com.example.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class UserForm {
    @NotNull(message = "性别不能为空")
    private Boolean sex;

    @NotNull(message = "年龄不能为空")
    private Integer age;

    @Digits(message = "只能输入两位小数", integer = Integer.MAX_VALUE, fraction = 2)
    private BigDecimal money;

    @NotEmpty(message = "手机号不能为空")
    @Pattern(message = "手机号格式不正确", regexp = "^1\\d{10}$")
    private String phone;

    @NotNull(message = "日期不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date date;

    @JsonFormat(pattern = "yyyy/MM/dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate localDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime localDateTime;
}
