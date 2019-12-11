package com.thoughtworks.aceleradora.service;

import com.thoughtworks.aceleradora.domain.Administrator;
import com.thoughtworks.aceleradora.repository.AdministratorRepository;
import org.springframework.stereotype.Service;

@Service
public class AdministratorService {

    private AdministratorRepository repository;

    public AdministratorService(AdministratorRepository repository) {
        this.repository = repository;
    }

    public Administrator save(Administrator administrator){
        return repository.save(administrator);
    }

}
