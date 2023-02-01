package com.example.reproducer;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

@Entity
public class OneEntity extends BaseEntity {

    @NotNull
    private String data;

    @OneToMany(mappedBy = "oneEntity", cascade = CascadeType.ALL)
    private Set<OtherEntity> otherEntityLazyLoaded = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent")
    private OtherEntity parent;

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

    public OtherEntity getParent() {
        return parent;
    }

    public void setParent(OtherEntity parent) {
        this.parent = parent;
    }
    
    
}
