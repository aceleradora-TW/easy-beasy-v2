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

    public Question getQuestion(int index) {
        return getAllQuestions().get(index);
    }

    public void addQuestion(Question question) {
        repository.addQuestion(question);
    }

    public Question removeQuestion(int index) {
        return repository.deleteQuestion(index);
    }

    public List<Question> getAllQuestions() {
        return repository.getAllQuestions();
    }
}
