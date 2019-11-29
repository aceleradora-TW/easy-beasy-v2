package com.thoughtworks.aceleradora.controller;

import com.thoughtworks.aceleradora.domain.Administrator;
import com.thoughtworks.aceleradora.service.AdministratorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cadastrar")
public class AdministratorController {

    private AdministratorService administratorService;

    public AdministratorController(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }

    @PostMapping("/")
    public void save(@RequestBody Administrator administrator) {

        administratorService.save(administrator);

    }
}
