package com.thoughtworks.aceleradora.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "stages")
public class Stage {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @OneToMany
    @JoinColumn(name = "fk_id_stage")
    private List<Question> questions;

    private String solution;
    private String hint;
    private int number;

    @JsonCreator
    public Stage() {
    }

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
