package com.example.moviecatalog.service;

import com.example.moviecatalog.model.Movie;
import com.example.moviecatalog.repository.DirectorRepository;
import com.example.moviecatalog.repository.MovieRepository;
import com.example.moviecatalog.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> findById(long id) {
        return movieRepository.findById(id);
    }

    @Override
    public Optional<List<Movie>> findMoviesByDirector(Long id) {
        return movieRepository.findByDirector(id);
    }

    @Override
    public Optional<List<Movie>> findMoviesByRating(Long rating) {
        return Optional.of(movieRepository.findAll().stream().filter(m -> m.getAverageRating() > rating).collect(Collectors.toList()));
    }
}
