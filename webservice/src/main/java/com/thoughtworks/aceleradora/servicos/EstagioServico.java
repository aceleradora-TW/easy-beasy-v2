package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.Estagio;
import com.thoughtworks.aceleradora.dominio.Pergunta;
import com.thoughtworks.aceleradora.repositorio.EstagioRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstagioServico {
    private EstagioRepositorio repositorio;

    public EstagioServico(EstagioRepositorio repositorio) {
        this.repositorio = repositorio;
    }
    public List<Estagio> pegarSolucoes() {
        return repositorio.pegaSolucoesEstagio();
    }
    public Estagio pegaSolucao(int indice) {
        return pegarSolucoes().get(indice);
    }


}
