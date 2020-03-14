package com.example.moviecatalog.service;

import java.util.Optional;
import java.util.Set;

public interface RepoServiceI<T> {
    void persist(T entity);
    void remove(T entity);
    Set<T> getAll();
    Optional<T> findById(long id);
}
