package com.thoughtworks.aceleradora.domain;

import org.hibernate.annotations.Entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class NetPromoterScore {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    private int score;
    private String comments;

    @Column(name = "id_users")
    @OneToOne
    private User user;

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
