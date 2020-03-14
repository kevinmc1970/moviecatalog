package com.example.moviecatalog.service;

import com.example.moviecatalog.model.Movie;
import com.example.moviecatalog.repository.DirectorRepository;
import com.example.moviecatalog.repository.MovieRepository;
import com.example.moviecatalog.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class MovieService implements MovieServiceI<Movie> {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    DirectorRepository directorRepository;

    @Autowired
    RatingRepository ratingRepository;


    @Override
    public void persist(Movie entity) {
        movieRepository.save(entity);
    }

    @Override
    public void remove(Movie entity) {
        movieRepository.delete(entity);
    }

    @Override
    public Set<Movie> getAll() {
        return (Set<Movie>)movieRepository.findAll();
    }

    @Override
    public Optional<Movie> findById(long id) {
        return movieRepository.findById(id);
    }

}
