package com.thoughtworks.aceleradora.domain;

import org.hibernate.annotations.Entity;
@Entity
public class NetPromoterScore {
    private long id;
    private int score;
    private String comments;

    public long getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public String getComments() {
        return comments;
    }

}
