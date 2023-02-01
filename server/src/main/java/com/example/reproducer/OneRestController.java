package com.example.reproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reproducer.dao.OneEntityRepository;
import com.example.reproducer.mapper.OneEntityDto;

@RestController
public class OneRestController {

    @Autowired
    private OneEntityRepository entityRepository;

    @Autowired
    private ConversionService conversionService;


    @Transactional
    @GetMapping("/read")
    public Page<OneEntityDto> read(Pageable pageable) {
        return entityRepository.findAll(pageable).map(o -> conversionService.convert(o, OneEntityDto.class));
    
    }

}
