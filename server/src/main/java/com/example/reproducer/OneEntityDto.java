package com.example.reproducer;

import java.util.Set;

import lombok.Data;

@Data
public class OneEntityDto {

    private Long id;
    private String data;

    private Set<OtherEntityDto> otherEntityLazyLoaded;
    
}
