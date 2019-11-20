package com.thoughtworks.aceleradora.controller;

import com.thoughtworks.aceleradora.domain.User;
import com.thoughtworks.aceleradora.service.UserService;
import com.thoughtworks.aceleradora.validators.ResponseEntityErrors;
import com.thoughtworks.aceleradora.validators.UserValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    private ResponseEntityErrors responseEntityErrors;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public ResponseEntity save(@RequestBody @Valid User user, BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            return new ResponseEntityErrors(bindingResult.getAllErrors()).build();
        }

        userService.save(user);

        return ResponseEntity.ok().build();
    }
}
