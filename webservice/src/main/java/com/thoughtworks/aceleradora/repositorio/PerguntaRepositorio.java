package com.thoughtworks.aceleradora.repositorio;

import com.thoughtworks.aceleradora.dominio.Pergunta;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class PerguntaRepositorio {
    private static ArrayList<Pergunta> perguntasDaTurma = new ArrayList<>(Arrays.asList(new Pergunta("Você está bem?"), new Pergunta("Qual sua idade?")));

    public List<Pergunta> pegaTodasPerguntasDaTurma() {
        return perguntasDaTurma;
    }

    public void adicionaPergunta(Pergunta pergunta) {
        perguntasDaTurma.add(pergunta);
    }

    public Pergunta deletaPergunta(int indice) {
        return perguntasDaTurma.remove(indice);
    }
}
