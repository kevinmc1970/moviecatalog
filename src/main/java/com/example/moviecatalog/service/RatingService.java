package com.example.moviecatalog.service;

import com.example.moviecatalog.model.Rating;
import com.example.moviecatalog.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService implements RatingServiceI<Rating> {

    @Autowired
    RatingRepository ratingRepository;


    @Override
    public void persist(Rating entity) {
        ratingRepository.save(entity);
    }

    @Override
    public void remove(Rating entity) {
        ratingRepository.delete(entity);
    }

    @Override
    public List<Rating> getAll() {
        return ratingRepository.findAll();
    }

    @Override
    public Optional<Rating> findById(long id) {
        return ratingRepository.findById(id);
    }

    @Override
    public List<Rating> getAllRatingsByMovie(Long movieId) {
        return ratingRepository.findRatingsByMovie(movieId);
    }
}
