package com.thoughtworks.aceleradora.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Question {
    private String descricao;

    @JsonCreator
    public Question(@JsonProperty("descricao") String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public Question setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }
}
