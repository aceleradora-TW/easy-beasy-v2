package com.thoughtworks.aceleradora.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InicioController {

    @GetMapping("/ws")
    public String renderizaPaginaInicial() {
        return "WS OK";
    }
}
