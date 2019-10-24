package com.thoughtworks.aceleradora.repositorio;

import com.thoughtworks.aceleradora.dominio.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class UserRepository {
    private ArrayList<User> userData = new ArrayList<>();

    public void addUser(User user){
        userData.add(user);
    }
}
