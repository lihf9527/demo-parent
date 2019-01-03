package com.example.controller;

import com.example.common.Result;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public Result<?> list() {
        return Result.SUCCESS;
    }

    @GetMapping("/create")
    public Result<?> create() {
        return Result.SUCCESS;
    }

    @GetMapping("/update")
    public Result<?> update() {
        return Result.SUCCESS;
    }

    @GetMapping("/{id}")
    public Result<?> info(@PathVariable Integer id) {
        return Result.SUCCESS;
    }
}
