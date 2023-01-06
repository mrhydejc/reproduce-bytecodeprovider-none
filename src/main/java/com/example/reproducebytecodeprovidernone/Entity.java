package com.example.reproducebytecodeprovidernone;

import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@jakarta.persistence.Entity
public class Entity {
    @Id
    private Long id;
    private String data;

    @OneToOne(fetch = FetchType.LAZY)
    private OtherEntityLazyLoaded otherEntityLazyLoaded;

    public Entity() {
    }

    public Entity(Long id, String data, OtherEntityLazyLoaded otherEntityLazyLoaded) {
        this.id = id;
        this.data = data;
        this.otherEntityLazyLoaded = otherEntityLazyLoaded;
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

    public OtherEntityLazyLoaded getOtherEntityLazyLoaded() {
        return otherEntityLazyLoaded;
    }

    public void setOtherEntityLazyLoaded(OtherEntityLazyLoaded otherEntityLazyLoaded) {
        this.otherEntityLazyLoaded = otherEntityLazyLoaded;
    }
}
