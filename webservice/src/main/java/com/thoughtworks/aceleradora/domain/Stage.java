package com.thoughtworks.aceleradora.domain;

import java.util.List;

public class Stage {
    private List<Question> questions;
    private String solution;
    private String name;

    public Stage() {
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Question question) {
        this.questions.add(question);
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
