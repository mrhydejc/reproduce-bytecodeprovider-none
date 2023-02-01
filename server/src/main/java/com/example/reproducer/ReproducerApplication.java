package com.example.reproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.reproducer.dao.OneEntityRepository;
import com.example.reproducer.model.OneEntity;
import com.example.reproducer.model.OtherEntity;

@SpringBootApplication
public class ReproducerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ReproducerApplication.class, args);
        OneEntityRepository repo1 = context.getBean(OneEntityRepository.class);
        
        OneEntity o1 = new OneEntity();
        o1.setData("data");
        OtherEntity o2 = new OtherEntity();
        o2.setName("name");
        o1.getOtherEntityLazyLoaded().add(o2);
        o2.setOneEntity(o1);

        repo1.save(o1);
    }

}
