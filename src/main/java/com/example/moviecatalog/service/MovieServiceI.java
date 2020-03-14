package com.example.moviecatalog.service;

import java.util.List;
import java.util.Optional;

public interface MovieServiceI<T> extends RepoServiceI<T> {

    Optional<List<T>> findMoviesByDirector(Long id);

    Optional<List<T>> findMoviesByRating(Long id);
}
