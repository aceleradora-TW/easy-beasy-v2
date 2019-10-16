package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.repositorio.EstagioRepositorio;
import org.springframework.stereotype.Service;

@Service
public class EstagioServico {
    private EstagioRepositorio estagioRepositorio;

    public EstagioServico(EstagioRepositorio estagioRepositorio) {
        this.estagioRepositorio = estagioRepositorio;
    }
}
