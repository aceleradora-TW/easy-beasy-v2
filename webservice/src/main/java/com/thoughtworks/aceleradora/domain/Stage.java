package com.thoughtworks.aceleradora.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Stage {
    private List<Question> questions = new ArrayList<>();
    private String solution;
    private String hint;
    private int number;
    private Long id;


    @JsonCreator
    public Stage(@JsonProperty("solution") String solution,
                 @JsonProperty("number") int number,
                 @JsonProperty("hint") String hint,
                 @JsonProperty("questions") List<Question> questions) {
        this.solution = solution;
        this.number = number;
        this.hint = hint;
        this.questions = questions;
    }

    public Stage(String solution, int number, String hint, ArrayList<Question> questions, Long id) {
        this(solution, number, hint, questions);
        this.id = id;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Question question) {
        this.questions.add(question);
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
