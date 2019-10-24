package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.Question;
import com.thoughtworks.aceleradora.repositorio.QuestionRepository;

import java.util.List;

public class QuestionService {

    private QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> salvar(Question question) {
        return questionRepository.salvar(question);
    }
}
