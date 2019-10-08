package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.Pergunta;
import com.thoughtworks.aceleradora.repositorio.PerguntaRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerguntaServico {
    private PerguntaRepositorio repositorio;

    public PerguntaServico(PerguntaRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Pergunta pegaPergunta(int indice) {
        return pegarMinhasPerguntas().get(indice);
    }

    public void adicionaPergunta(Pergunta pergunta) {
        pergunta.setDescricao(pergunta.getDescricao() + " Perguntado por: Turma 16");

        repositorio.adicionaPergunta(pergunta);
    }

    public Pergunta removePergunta(int indice) {
        return repositorio.deletaPergunta(indice);
    }

    public List<Pergunta> pegarMinhasPerguntas() {
        return repositorio.pegaTodasPerguntasDaTurma();
    }
}
