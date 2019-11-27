package com.thoughtworks.aceleradora.service;

import com.thoughtworks.aceleradora.domain.User;
import com.thoughtworks.aceleradora.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void shouldReturnOkIfRepositorySaveValidUser(){
        User userExpected = new User(1L,"Lucilaine", "lucilaine@email.com");

        Mockito.when(userRepository.save(userExpected)).thenReturn(userExpected);

        User user = userService.save(userExpected);

        Assert.assertEquals(user.getName(), "Lucilaine");
        Assert.assertEquals(user.getEmail(), "lucilaine@email.com");

    }
}
