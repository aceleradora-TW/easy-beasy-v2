package com.thoughtworks.aceleradora.repository;

import com.thoughtworks.aceleradora.domain.User;
import com.thoughtworks.aceleradora.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class UserRepositoryTest {
    @Test
    public void shouldReturnOKIfISaveAValidUser(){

        User user = new User("Lucilaine", "lucilaine@email.com");
        UserRepository userRepository = new UserRepository();
        List<User> users = userRepository.save(user);

        User userResult = users.get(0);
        Assert.assertEquals(userResult.getName(),"Lucilaine");
        Assert.assertEquals(userResult.getEmail(),"lucilaine@email.com");
    }
}
