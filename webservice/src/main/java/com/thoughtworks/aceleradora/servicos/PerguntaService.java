package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.Pergunta;
import com.thoughtworks.aceleradora.repositorio.PerguntaRepository;

import java.util.List;

public class PerguntaService {

    private PerguntaRepository perguntaRepository;

    public PerguntaService(PerguntaRepository perguntaRepository) {
        this.perguntaRepository = perguntaRepository;
    }

    public List<Pergunta> salvar(Pergunta pergunta) {
        return perguntaRepository.salvar(pergunta);
    }
}
