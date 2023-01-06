package com.example.reproducebytecodeprovidernone;

import jakarta.persistence.Id;

@jakarta.persistence.Entity
public class Entity {
    @Id
    private Long id;
    private String data;

    public Entity() {
    }

    public Entity(Long id, String data) {
        this.id = id;
        this.data = data;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
