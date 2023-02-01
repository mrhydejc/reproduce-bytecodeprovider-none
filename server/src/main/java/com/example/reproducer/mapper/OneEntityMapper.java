package com.example.reproducer.mapper;

import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

import com.example.reproducer.config.MapperSpringConfig;
import com.example.reproducer.model.OneEntity;

@Mapper(config = MapperSpringConfig.class)
public interface OneEntityMapper extends Converter<OneEntity, OneEntityDto> {

    OneEntityDto convert(OneEntity bean);
}
