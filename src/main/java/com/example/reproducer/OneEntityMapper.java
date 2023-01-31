package com.example.reproducer;

import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(config = MapperSpringConfig.class)
public interface OneEntityMapper extends Converter<OneEntity, OneEntityDto> {

    OneEntityDto convert(OneEntity bean);
}
