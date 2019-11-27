package com.thoughtworks.aceleradora.domain;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "areas")
public class Area {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    private String name;

    @OneToMany
    @JoinColumn(name = "id_area")
    private List<Stage> stages;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
