package com.thoughtworks.aceleradora.dominio;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Pergunta {
    private String descricao;

    @JsonCreator
    public Pergunta(@JsonProperty("descricao") String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public Pergunta setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }
}
