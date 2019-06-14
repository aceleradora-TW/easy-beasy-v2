package com.thoughtworks.aceleradora.controllers;

import com.thoughtworks.aceleradora.dominio.Pessoa;
import com.thoughtworks.aceleradora.dominio.PessoaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ws/pessoas")
public class PessoaController {

    private PessoaRepository repositorio;

    public PessoaController(PessoaRepository repositorio) {
        this.repositorio = repositorio;
    }

    @GetMapping("")
    public List<Pessoa> getAll() {
        return repositorio.findAll();
    }

    @PostMapping("/save")
    @ResponseBody
    public Pessoa salvaCadastro(Pessoa pessoa) {

        return repositorio.save(pessoa);
    }

}
