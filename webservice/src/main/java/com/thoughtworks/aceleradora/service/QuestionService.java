package com.thoughtworks.aceleradora.service;

import com.thoughtworks.aceleradora.domain.Question;
import com.thoughtworks.aceleradora.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    private QuestionRepository repositorio;

    public QuestionService(QuestionRepository repositorio) {
        this.repositorio = repositorio;
    }

    public Question pegaPergunta(int indice) {
        return pegarMinhasPerguntas().get(indice);
    }

    public void adicionaPergunta(Question question) {
        question.setDescricao(question.getDescricao() + " Perguntado por: Turma 16");

        repositorio.adicionaPergunta(question);
    }

    public Question removePergunta(int indice) {
        return repositorio.deletaPergunta(indice);
    }

    public List<Question> pegarMinhasPerguntas() {
        return repositorio.pegaTodasPerguntasDaTurma();
    }
}
