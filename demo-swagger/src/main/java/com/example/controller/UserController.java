package com.example.controller;

import com.example.common.Result;
import com.example.form.UserForm;
import com.example.service.ExceptionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

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

    @PostMapping("list")
    public Result list(@Valid UserForm form) {
        System.out.println(form);
        System.out.println(form.getDate().toLocaleString());
        return Result.success(form);
    }
}
