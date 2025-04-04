package org.example.service;

import org.example.exception.DataNotFoundException;


public interface Service<T> {
    void create(T t);

    T readById(Long id) throws DataNotFoundException;

    void update(T t);

    void delete(Long id);

}
