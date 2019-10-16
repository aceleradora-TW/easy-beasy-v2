package com.thoughtworks.aceleradora.dominio;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Estagio {
    private int ordem;
    private List<Pergunta> perguntas;
    private String solucao;
    private String nome;

    public Estagio() {
        perguntas = new ArrayList<>();
    }
    @JsonCreator
    public Estagio(@JsonProperty("solucao") String solucao) {
        this.solucao = solucao;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public List<Pergunta> getPerguntas() {
        return perguntas;
    }

    public String getSolucao() {
        return solucao;
    }

    public void setSolucao(String solucao) {
        this.solucao = solucao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
