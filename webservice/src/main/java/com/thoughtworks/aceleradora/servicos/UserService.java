package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.User;
import com.thoughtworks.aceleradora.repositorio.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository repository;

    public UserService (UserRepository repository){
        this.repository = repository;
    }

    public List<User> addUser(User user){
        return repository.addUser(user);
    }
}
