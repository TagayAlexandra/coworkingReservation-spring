package org.example.service;

import org.example.dto.WorkSpaceDto;

import java.util.List;

public interface WorkSpaceService extends Service<WorkSpaceDto> {
    List<WorkSpaceDto> readAllBookingWorkSpaces();

    List<WorkSpaceDto> readAllAvailableWorkSpaces();
}
