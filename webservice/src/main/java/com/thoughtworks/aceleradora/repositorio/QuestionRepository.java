package com.thoughtworks.aceleradora.repositorio;

import com.thoughtworks.aceleradora.dominio.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionRepository {

    private List<Question> questions;

    public QuestionRepository() {
        questions = new ArrayList<Question>();
    }

    public List<Question> salvar(Question question) {
        if (question.getDescription() != null) {
            questions.add(question);
        }
        return questions;
    }
}
