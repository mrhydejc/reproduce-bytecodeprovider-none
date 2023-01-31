package com.example.reproducer;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class OneEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String data;

    @OneToMany(mappedBy = "oneEntity", cascade = CascadeType.ALL)
    private Set<OtherEntity> otherEntityLazyLoaded = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Set<OtherEntity> getOtherEntityLazyLoaded() {
        return otherEntityLazyLoaded;
    }

    public void setOtherEntityLazyLoaded(Set<OtherEntity> otherEntityLazyLoaded) {
        this.otherEntityLazyLoaded = otherEntityLazyLoaded;
    }

    
}
