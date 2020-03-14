package com.example.moviecatalog.repository;

import com.example.moviecatalog.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    @Query("SELECT r FROM Rating r WHERE r.movie.id = ?1")
    List<Rating> findRatingsByMovie(Long movieId);
}

