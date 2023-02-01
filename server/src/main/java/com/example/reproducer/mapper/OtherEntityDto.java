package com.example.reproducer.mapper;

import lombok.Data;

@Data
public class OtherEntityDto {

    private Long id;
    private String name;
    private OtherEntityDto parent;

}
