package com.thoughtworks.aceleradora.controller;

import com.thoughtworks.aceleradora.domain.Question;
import com.thoughtworks.aceleradora.services.QuestionService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/testeum")
public class QuestionController {
    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(path = "/")
    public List<Question> pegaListaDePerguntas() {
        return questionService.pegarMinhasPerguntas();
    }

    @PostMapping(path = "/")
    public void adicionaPergunta(@RequestBody Question question) {
        questionService.adicionaPergunta(question);
    }

    @GetMapping(path = "/{indice}")
    public Question pegaPergunta(@PathVariable("indice") int indice) {
        return questionService.pegaPergunta(indice);
    }

    @DeleteMapping(path = "/{indice}")
    public Question removePergunta(@PathVariable("indice") int indice) {
        return questionService.removePergunta(indice);
    }
}
