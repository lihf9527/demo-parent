package com.example.controller;

import com.example.form.UserForm;
import com.example.common.Result;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Validated
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @GetMapping("/hello/{name}")
    @ApiOperation(value = "入门 hello 案例", notes = "创建人: 李海峰")
    public Result hello(@ApiParam("名称") @NotBlank(message = "名称不能为空") @PathVariable String name) {
        return Result.success(name);
    }

    @PostMapping("list")
    public Result list(@Valid UserForm form, BindingResult result) {
        System.out.println(form);
        return Result.SUCCESS;
    }
}
