package com.example.reproducer;

import java.util.Optional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reproducer.dao.OneEntityRepository;
import com.example.reproducer.mapper.OneEntityDto;
import com.example.reproducer.model.OneEntity;
import com.example.reproducer.model.OtherEntity;

@RestController
public class OneRestController {

    @Autowired
    private OneEntityRepository entityRepository;

    @Autowired
    private ConversionService conversionService;


    @Transactional
    @GetMapping("/read1")
    public Page<OneEntityDto> read1(Pageable pageable) {

        OneEntity o1 = new OneEntity();
        o1.setData(RandomStringUtils.random(10));

        OtherEntity o2 = new OtherEntity();
        o2.setName(RandomStringUtils.random(10));
        o1.getOtherEntityLazyLoaded().add(o2);
        o2.setOneEntity(o1);

        o1 = entityRepository.save(o1);

        OneEntity o3 = new OneEntity();
        o3.setData(RandomStringUtils.random(10));
        o3 = entityRepository.save(o3);

        Optional<OneEntity> oo1 = entityRepository.findById(o1.getId());
        Optional<OneEntity> oo3 = entityRepository.findById(o3.getId());
        o1 = oo1.get();
        o1.getChildSet().add(oo3.get());
        o1 = entityRepository.save(o1);
        
        return entityRepository.findAll(pageable).map(o -> conversionService.convert(o, OneEntityDto.class));
    
    }

}
