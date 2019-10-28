package com.thoughtworks.aceleradora.controller;

import com.thoughtworks.aceleradora.domain.Question;
import com.thoughtworks.aceleradora.service.QuestionService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(path = "")
    public List<Question> getListQuestions() {
        return questionService.getAllQuestions();
    }

    @PostMapping(path = "")
    public void addQuestion(@RequestBody Question question) {
        questionService.addQuestion(question);
    }

    @GetMapping(path = "/{index}")
    public Question getQuestion(@PathVariable("index") int index) {
        return questionService.getQuestion(index);
    }

    @DeleteMapping(path = "/{index}")
    public Question removeQuestion(@PathVariable("index") int index) {
        return questionService.removeQuestion(index);
    }
}
