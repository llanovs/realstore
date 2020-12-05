package com.realstore.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class User {

    private final UUID id;
    private String name;
    private String password;

    public User(@JsonProperty("userName") String name,
                @JsonProperty("userPassword") String password) {
        this.id = generateId();
        this.name = name;
        this.password = password;
    }

    public User(@JsonProperty("userId") UUID id,
                @JsonProperty("userName") String name,
                @JsonProperty("userPassword") String password) {
        this.id = id == null ? generateId() : id;
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public UUID generateId(){
        return UUID.randomUUID();
    }
}
