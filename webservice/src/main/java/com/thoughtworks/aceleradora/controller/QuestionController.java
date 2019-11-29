package com.thoughtworks.aceleradora.controller;

import com.thoughtworks.aceleradora.domain.Question;
import com.thoughtworks.aceleradora.service.QuestionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/question")
public class QuestionController {
    private QuestionService questionService;


    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/")
    public Question save(@RequestBody Question question) {
        return questionService.save(question);
    }
}
