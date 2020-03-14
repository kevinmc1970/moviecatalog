package com.example.moviecatalog.service;

import com.example.moviecatalog.model.Director;
import com.example.moviecatalog.model.Movie;
import com.example.moviecatalog.repository.DirectorRepository;
import com.example.moviecatalog.repository.MovieRepository;
import com.example.moviecatalog.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DirectorService implements RepoServiceI<Director> {

    @Autowired
    DirectorRepository directorRepository;

    @Autowired
    RatingRepository ratingRepository;


    @Override
    public void persist(Director entity) {
        directorRepository.save(entity);
    }

    @Override
    public void remove(Director entity) {
        directorRepository.delete(entity);
    }

    @Override
    public List<Director> getAll() {
        return directorRepository.findAll();
    }

    @Override
    public Optional<Director> findById(long id) {
        return directorRepository.findById(id);
    }

}
