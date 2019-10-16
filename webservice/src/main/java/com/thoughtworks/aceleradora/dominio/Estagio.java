package com.thoughtworks.aceleradora.dominio;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Estagio {
    private String solucao;

    @JsonCreator
    public Estagio(@JsonProperty("solucao") String solucao) {
        this.solucao = solucao;
    }

    public String getSolucao() {
        return solucao;
    }
}