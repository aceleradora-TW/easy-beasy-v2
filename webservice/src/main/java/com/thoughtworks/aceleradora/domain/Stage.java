package com.thoughtworks.aceleradora.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Stage {
    private String solution;

    @JsonCreator
    public Stage(@JsonProperty("solution") String solution) {
        this.solution = solution;
    }

    public String getSolution() {
        return solution;
    }
}