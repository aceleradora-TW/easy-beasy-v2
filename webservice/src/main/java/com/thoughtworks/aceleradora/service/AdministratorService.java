package com.thoughtworks.aceleradora.service;

import com.thoughtworks.aceleradora.domain.Administrator;
import com.thoughtworks.aceleradora.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdministratorService {

    private AdministratorRepository repository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public AdministratorService(AdministratorRepository repository) {
        this.repository = repository;
    }
    public Administrator save(Administrator administrator){
        administrator.setPassword(passwordEncoder.encode(administrator.getPassword()));
        return repository.save(administrator);
    }

}
