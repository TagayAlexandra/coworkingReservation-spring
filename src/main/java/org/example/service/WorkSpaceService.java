package org.example.service;

import org.example.entity.WorkSpace;

import java.util.List;

public interface WorkSpaceService extends Service<WorkSpace> {
    List<WorkSpace> readAllBookingWorkSpaces();

    List<WorkSpace> readAllAvailableWorkSpaces();
}
