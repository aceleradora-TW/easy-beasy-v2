package com.thoughtworks.aceleradora.controller;

import com.thoughtworks.aceleradora.domain.Question;
import com.thoughtworks.aceleradora.service.QuestionService;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


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

    @GetMapping(path = "")
    public List<Question> getQuestions(){
        return questionService.getAllQuestions();
    }
}
