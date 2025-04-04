package org.example.mapper;

import org.mapstruct.Mapper;

import org.mapstruct.factory.Mappers;

@Mapper
public interface WorkSpaceMapper {
    WorkSpaceMapper INSTANCE = Mappers.getMapper(WorkSpaceMapper.class);


}
