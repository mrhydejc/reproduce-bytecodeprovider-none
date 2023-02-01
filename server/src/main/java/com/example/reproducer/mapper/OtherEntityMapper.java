package com.example.reproducer.mapper;

import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

import com.example.reproducer.config.MapperSpringConfig;
import com.example.reproducer.model.OtherEntity;

@Mapper(config = MapperSpringConfig.class)
public interface OtherEntityMapper extends Converter<OtherEntity, OtherEntityDto> {

    OtherEntityDto convert(OtherEntity bean);
}
