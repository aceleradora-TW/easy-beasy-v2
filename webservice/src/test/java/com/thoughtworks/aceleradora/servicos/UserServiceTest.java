package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.User;
import com.thoughtworks.aceleradora.repositorio.UserRepository;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class UserServiceTest {

    @Test
    public void shouldReturnOkIfRepositorySaveValidUser(){
        User userExpected = new User("Lucilaine", "lucilaine@email.com");
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);
        List<User> users = userService.addUser(userExpected);

        User userResult = users.get(0);
        Assert.assertEquals(userResult.getName(), userExpected.getName());
        Assert.assertEquals(userResult.getEmail(), userExpected.getEmail());


    }
}
