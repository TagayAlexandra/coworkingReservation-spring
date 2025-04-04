package org.example.service;

import org.example.dto.WorkSpaceDto;
import org.example.entity.WorkSpace;
import org.example.exception.DataNotFoundException;
import org.example.mapper.WorkSpaceMapper;
import org.example.repository.WorkSpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class WorkSpaceServiceImp implements WorkSpaceService {

    @Autowired
    private WorkSpaceRepository repository;

    @Override
    public void create(WorkSpaceDto workSpaceDto) {
        repository.save(WorkSpaceMapper.INSTANCE.toEntity(workSpaceDto));

    }

    @Override
    public WorkSpaceDto readById(Long id) throws DataNotFoundException {
        return repository.findById(id).map(WorkSpaceMapper.INSTANCE::toDto).
                orElseThrow(() -> new DataNotFoundException("Data not found with id" + id));
    }

    @Override
    public void update(WorkSpaceDto workSpaceDto) {
        WorkSpace workSpace = WorkSpaceMapper.INSTANCE.toEntity(workSpaceDto);
        if (repository.existsById(workSpace.getId())) {
            repository.save(workSpace);
        }

    }

    @Override
    public void delete(Long id) {

        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }

    @Override
    public List<WorkSpaceDto> readAllBookingWorkSpaces() {

        return repository.readAllBookingWorkSpaces().stream().map(WorkSpaceMapper.INSTANCE::toDto).toList();
    }

    @Override
    public List<WorkSpaceDto> readAllAvailableWorkSpaces() {
        return repository.readAllAvailableWorkSpaces().stream().map(WorkSpaceMapper.INSTANCE::toDto).toList();
    }
}
