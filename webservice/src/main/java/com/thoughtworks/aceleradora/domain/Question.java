package com.thoughtworks.aceleradora.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String description;

    private Long id_stage;

    @JsonCreator
    public Question(@JsonProperty("description") String description, @JsonProperty("id_stage") Long id_stage) {
        this.description = description;
        this.id_stage = id_stage;
    }

    @JsonCreator
    public Question() {
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
