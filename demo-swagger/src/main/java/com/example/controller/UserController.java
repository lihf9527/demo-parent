package com.example.controller;

import com.example.common.Result;
import com.example.form.UserForm;
import com.example.service.ExceptionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Api(tags = "用户管理")
@Validated
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private ExceptionService exceptionService;

    @GetMapping("/hello/{name}")
    @ApiOperation(value = "入门 hello 案例", notes = "创建人: 李海峰")
    public Result hello(@ApiParam("名称") @NotBlank(message = "名称不能为空") @PathVariable String name) {
        return Result.success(name);
    }

    @PostMapping("/list")
    @ApiOperation(value = "用户列表", notes = "创建人: 李海峰")
    public Result list(@Valid UserForm form) {
        System.out.println(form);
        System.out.println(form.getDate().toLocaleString());
        return Result.success(form);
    }

    @GetMapping("/info")
    @ApiOperation(value = "用户详情", notes = "创建人: 李海峰")
    public Result test(
            @ApiParam("用户ID")
            @NotNull(message = "ID不能为空")
            @RequestParam Integer id) {
        return Result.success(id);
    }

    @GetMapping("/email")
    @ApiOperation(value = "电子邮箱", notes = "创建人: 李海峰")
    public Result email(
            @ApiParam("电子邮箱")
            @Email(message = "邮箱格式不正确")
            @NotEmpty(message = "电子邮箱不能为空")
            @RequestParam String email) {
        return Result.success(email);
    }
}
