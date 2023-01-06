package com.example.reproducebytecodeprovidernone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.random.RandomGenerator;

@Component
public class EntityHandler {

    @Autowired
    private EntityRepository entityRepository;
    @Autowired
    private OtherEntityRepository otherEntityRepository;

    public long trigger() {
        final OtherEntityLazyLoaded otherEntityLazyLoaded = new OtherEntityLazyLoaded();
        otherEntityRepository.save(otherEntityLazyLoaded);
        entityRepository.save(new Entity(RandomGenerator.getDefault().nextLong(), "someData", otherEntityLazyLoaded));
        return entityRepository.count();
    }

    public String loadById() {
        final Entity entity = entityRepository.findById(entityRepository.findAll().get(0).getId()).get();
        return entity.getData() + entity.getOtherEntityLazyLoaded().getId();
    }
}
