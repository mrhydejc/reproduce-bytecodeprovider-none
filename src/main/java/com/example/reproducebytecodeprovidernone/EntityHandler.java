package com.example.reproducebytecodeprovidernone;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.random.RandomGenerator;

@Component
public class EntityHandler {

    @Autowired
    private Repository repository;

    @PostConstruct
    public void init() {
        repository.save(new Entity(1L,"someData"));
    }

    @Transactional
    public long trigger() {
        repository.save(new Entity(RandomGenerator.getDefault().nextLong(), "someData"));
        return repository.count();
    }

    public String loadById(long id) {
        return repository.getReferenceById(id).getData();
    }
}
