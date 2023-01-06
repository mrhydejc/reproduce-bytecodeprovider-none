package com.example.reproducebytecodeprovidernone;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.random.RandomGenerator;

@Entity
public class OtherEntityLazyLoaded {


    @Id
    private Long id;

    public OtherEntityLazyLoaded() {
        id = RandomGenerator.getDefault().nextLong();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
