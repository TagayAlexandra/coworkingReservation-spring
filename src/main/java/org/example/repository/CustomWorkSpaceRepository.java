package org.example.repository;

import org.example.entity.WorkSpace;

import java.util.List;

public interface CustomWorkSpaceRepository {

    List<WorkSpace> readAllBookingWorkSpaces();

    List<WorkSpace> readAllAvailableWorkSpaces();

}
