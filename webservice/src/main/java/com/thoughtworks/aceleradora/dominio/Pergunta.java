package com.thoughtworks.aceleradora.dominio;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Pergunta {

    private Integer ordem;
    private String descricao;

    public Pergunta() {

    }

    public Pergunta(Integer ordem, String descricao) {
        this.ordem = ordem;
        this.descricao = descricao;
    }

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

    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }

}
