package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.Question;
import com.thoughtworks.aceleradora.repositorio.PerguntaRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerguntaServico {
    private PerguntaRepositorio repositorio;

    public PerguntaServico(PerguntaRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Question pegaPergunta(int indice) {
        return pegarMinhasPerguntas().get(indice);
    }

    public void adicionaPergunta(Question question) {
        question.setDescription(question.getDescription() + " Perguntado por: Turma 16");

        repositorio.adicionaPergunta(question);
    }

    public Question removePergunta(int indice) {
        return repositorio.deletaPergunta(indice);
    }

    public List<Question> pegarMinhasPerguntas() {
        return repositorio.pegaTodasPerguntasDaTurma();
    }
}
