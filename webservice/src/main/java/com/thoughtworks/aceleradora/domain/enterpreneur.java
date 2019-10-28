package com.thoughtworks.aceleradora.domain;

public class enterpreneur {
    private long id;
    private String name;
    private String email;

    public enterpreneur() {
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
