package org.example.mapper;

import org.example.dto.BookDetailDto;
import org.example.entity.BookDetail;
import org.mapstruct.Mapper;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookDetailMapper {
    BookDetailMapper INSTANCE = Mappers.getMapper(BookDetailMapper.class);

    @Mapping(target = "id", ignore = true)
    BookDetail toEntity(BookDetailDto bookDetailDto);

    BookDetailDto toDto(BookDetail bookDetail);


}
