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

    @OneToOne
    @JoinColumn(name = "id_users", referencedColumnName = "id")
    private User user;

    public long getId(){
        return id;
    }

    public int getScore(){
        return score;
    }

    public String getComments(){
        return comments;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

}
