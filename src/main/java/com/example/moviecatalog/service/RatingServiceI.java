package com.example.moviecatalog.service;

import com.example.moviecatalog.model.Rating;

import java.util.List;

public interface RatingServiceI<T> extends RepoServiceI<T> {

    List<Rating> getAllRatingsByMovie(Long movieId);

}
