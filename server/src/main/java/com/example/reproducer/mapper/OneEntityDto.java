package com.example.reproducer.mapper;

import java.util.Set;

import lombok.Data;

@Data
public class OneEntityDto {

    private Long id;
    private String data;

    private Set<OtherEntityDto> otherEntityLazyLoaded;

    private OneEntityDto parent;
    
}
