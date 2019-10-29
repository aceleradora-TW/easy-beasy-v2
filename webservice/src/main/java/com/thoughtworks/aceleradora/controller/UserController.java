package com.thoughtworks.aceleradora.controller;

import com.thoughtworks.aceleradora.domain.User;
import com.thoughtworks.aceleradora.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/")
    public void save (@RequestBody User user){
        userService.save(user);
    }
}
