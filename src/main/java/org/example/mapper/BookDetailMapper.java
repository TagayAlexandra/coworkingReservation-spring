package org.example.mapper;
import org.mapstruct.Mapper;

import org.mapstruct.factory.Mappers;

@Mapper
public interface BookDetailMapper {
    BookDetailMapper INSTANCE = Mappers.getMapper(BookDetailMapper.class);


}
