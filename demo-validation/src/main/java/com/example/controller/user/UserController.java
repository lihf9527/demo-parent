package com.example.controller.user;

import com.example.controller.ApiController;
import com.example.model.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@Validated
@RestController
@RequestMapping("/api/user")
public class UserController extends ApiController {

    @GetMapping("/{id}")
    public User user(@PathVariable @Min(value = 1, message = "最小值为1") Integer id) {
        User user = new User();
        user.setUsername(id.toString());
        if (true) {
            throw new NullPointerException();
        }
        return user;
    }

    @PostMapping("/create")
    public User create(@Valid User user, BindingResult result) {
//        if (result.hasErrors()) {
//            System.out.println(result.getFieldErrorCount());
//            System.out.println(result.getFieldError().getDefaultMessage());
//            System.out.println("============华丽的分割线=============");
//            result.getFieldErrors().forEach(fieldError -> System.out.println(fieldError.getDefaultMessage()));
//        }
        return user;
    }
}
