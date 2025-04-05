package org.example.mapper;

import org.example.dto.WorkSpaceDto;
import org.example.entity.WorkSpace;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WorkSpaceMapper {
    WorkSpaceMapper INSTANCE = Mappers.getMapper(WorkSpaceMapper.class);

    @Mapping(target = "id", ignore = true)
    WorkSpace toEntity(WorkSpaceDto workSpaceDto);

    WorkSpaceDto toDto(WorkSpace workSpace);


}
