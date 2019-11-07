package com.thoughtworks.aceleradora.domain;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "net_promoter_score")
public class NetPromoterScore {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    private int score;
    private String comments;


    public long getId(){
        return id;
    }

    public int getScore() {
        return score;
    }

    public String getComments() {
        return comments;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
