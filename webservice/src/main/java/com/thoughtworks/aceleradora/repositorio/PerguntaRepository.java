package com.thoughtworks.aceleradora.repositorio;

import com.thoughtworks.aceleradora.dominio.Pergunta;

import java.util.ArrayList;
import java.util.List;

public class PerguntaRepository {

    private List<Pergunta> perguntas;

    public PerguntaRepository() {
        perguntas = new ArrayList<Pergunta>();
    }

    public List<Pergunta> salvar(Pergunta pergunta) {
        if (pergunta.getDescricao() != null) {
            perguntas.add(pergunta);
        }
        return perguntas;
    }
}
