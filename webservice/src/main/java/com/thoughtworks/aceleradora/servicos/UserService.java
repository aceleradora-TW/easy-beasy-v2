package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.User;
import com.thoughtworks.aceleradora.repositorio.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository repository;

    public UserService (UserRepository repository){
        this.repository = repository;
    }

    public void addUser(User user){
        repository.addUser(user);
    }
}
