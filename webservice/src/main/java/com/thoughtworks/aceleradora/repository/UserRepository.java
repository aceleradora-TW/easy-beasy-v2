package com.thoughtworks.aceleradora.repository;

import com.thoughtworks.aceleradora.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class UserRepository {
    private ArrayList<User> userData = new ArrayList<>();

    public ArrayList<User> save(User user){
        userData.add(user);
        return userData;
    }
}
