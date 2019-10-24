package com.thoughtworks.aceleradora.dominio;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Question {

    private Integer priority;
    private String description;

    public Question() {

    }

    public Question(Integer priority, String description) {
        this.priority = priority;
        this.description = description;
    }

    @JsonCreator
    public Question(@JsonProperty("descricao") String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPriority() {
        return priority;
    }

}
