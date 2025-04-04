package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.example.entity.WorkSpace;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class CustomWorkSpaceRepositoryImpl implements CustomWorkSpaceRepository {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<WorkSpace> readAllBookingWorkSpaces() {
        TypedQuery<WorkSpace> query = entityManager.createNamedQuery("SELECT ws FROM WorkSpace ws WHERE ws.isAvailable = false", WorkSpace.class);
        return query.getResultList();

    }

    @Override
    public List<WorkSpace> readAllAvailableWorkSpaces() {
        TypedQuery<WorkSpace> query = entityManager.createNamedQuery("SELECT ws FROM WorkSpace ws WHERE ws.isAvailable = true", WorkSpace.class);
        return query.getResultList();
    }
}
