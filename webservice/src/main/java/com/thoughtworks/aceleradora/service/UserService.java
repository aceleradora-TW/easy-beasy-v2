package com.thoughtworks.aceleradora.service;

import com.thoughtworks.aceleradora.domain.User;
import com.thoughtworks.aceleradora.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository repository;

    public UserService (UserRepository repository){
        this.repository = repository;
    }

    public List<User> save(User user){
        return repository.save(user);
    }
}
