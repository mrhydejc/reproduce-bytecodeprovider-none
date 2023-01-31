package com.example.reproducer;

import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(config = MapperSpringConfig.class)
public interface OtherEntityMapper extends Converter<OtherEntity, OtherEntityDto> {

    OtherEntityDto convert(OtherEntity bean);
}
