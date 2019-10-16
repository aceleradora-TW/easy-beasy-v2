package com.thoughtworks.aceleradora.service;

import com.thoughtworks.aceleradora.domain.Question;
import com.thoughtworks.aceleradora.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    private QuestionRepository repository ;

    public QuestionService(QuestionRepository repository) {
        this.repository = repository;
    }

    public Question getQuestion(int indice) {
        return getMyQuestions().get(indice);
    }

    public void addQuestion(Question question) {
        question.setDescription(question.getDescription());

        repository.addQuestion(question);
    }

    public Question removeQuestion(int indice) {
        return repository.deleteQuestion(indice);
    }

    public List<Question> getMyQuestions() {
        return repository.getAllClassQuestions();
    }
}
