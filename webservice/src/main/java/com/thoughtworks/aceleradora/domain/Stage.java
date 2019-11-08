package com.thoughtworks.aceleradora.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Stage {
    private List<Question> questions= new ArrayList<>();
    private String solution;
    private String doubt;
    private int number;


    @JsonCreator
    public Stage(@JsonProperty("solution") String solution,
                 @JsonProperty("number") int number,
                 @JsonProperty("doubt") String doubt,
                 @JsonProperty("questions") List<Question> questions) {
        this.solution = solution;
        this.number = number;
        this.doubt =  doubt;
        this.questions = questions;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Question question) {
        this.questions.add(question);
    }

    public String getDoubt() {
        return doubt;
    }

    public void setDoubt(String doubt) {
        this.doubt = doubt;
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

}
