package com.thoughtworks.aceleradora.domain;

public class Enterpreneur {
    private long id;
    private String name;
    private String email;

    public Enterpreneur() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
