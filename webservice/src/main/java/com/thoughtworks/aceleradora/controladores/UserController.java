package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.User;
import com.thoughtworks.aceleradora.servicos.UserService;
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
    public void addUser (@RequestBody User user){
        userService.addUser(user);
    }
}
