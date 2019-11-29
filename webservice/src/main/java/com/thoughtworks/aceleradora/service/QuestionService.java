package com.thoughtworks.aceleradora.service;

import com.thoughtworks.aceleradora.domain.Question;
import com.thoughtworks.aceleradora.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class QuestionService {
    private QuestionRepository repository;

    @Autowired
    public QuestionService(QuestionRepository repository) {
        this.repository = repository;
    }

    public Question save(Question question) {
        return repository.save(question);
    }

    public List<Question> getAllQuestions() {
        return repository.findAll();
    }
}
