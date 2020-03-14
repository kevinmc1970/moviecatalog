package com.example.moviecatalog.service;

import com.example.moviecatalog.model.Director;
import com.example.moviecatalog.model.Rating;
import com.example.moviecatalog.repository.DirectorRepository;
import com.example.moviecatalog.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class RatingService implements RepoServiceI<Rating> {

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
    public Set<Rating> getAll() {
        return (Set<Rating>)ratingRepository.findAll();
    }

    @Override
    public Optional<Rating> findById(long id) {
        return ratingRepository.findById(id);
    }

}
