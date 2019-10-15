package com.thoughtworks.aceleradora.repository;

import com.thoughtworks.aceleradora.domain.Question;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class QuestionRepository {
    private static ArrayList<Question> perguntasDaTurma = new ArrayList<>(Arrays.asList(new Question("Você está bem?"), new Question("Qual sua idade?")));

    public List<Question> pegaTodasPerguntasDaTurma() {
        return perguntasDaTurma;
    }

    public void adicionaPergunta(Question question) {
        perguntasDaTurma.add(question);
    }

    public Question deletaPergunta(int indice) {
        return perguntasDaTurma.remove(indice);
    }
}
