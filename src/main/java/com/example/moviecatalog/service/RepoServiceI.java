package com.example.moviecatalog.service;

import java.util.List;
import java.util.Optional;

public interface RepoServiceI<T> {
    void persist(T entity);
    void remove(T entity);
    List<T> getAll();
    Optional<T> findById(long id);
}
