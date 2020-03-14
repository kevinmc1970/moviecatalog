package com.example.moviecatalog;

import com.example.moviecatalog.model.Director;
import com.example.moviecatalog.model.Movie;
import com.example.moviecatalog.model.Rating;
import com.example.moviecatalog.repository.DirectorRepository;
import com.example.moviecatalog.repository.MovieRepository;
import com.example.moviecatalog.repository.RatingRepository;
import com.example.moviecatalog.service.DirectorService;
import com.example.moviecatalog.service.MovieService;
import com.example.moviecatalog.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RatingController {

    @Autowired
    MovieService movieService;

    @Autowired
    RatingService ratingService;

    @GetMapping("/ratings/{id}")
    public String getRatings(@PathVariable("id") long id, Model model) {
        Movie movie = movieService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid movie Id:" + id));
        model.addAttribute("movie", movie);
        model.addAttribute("ratings", ratingService.getAll());
        return "ratings";
    }

    @GetMapping("/rating/{id}")
    public String showForm(@PathVariable("id") long id, Model model) {
        Movie movie = movieService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid movie Id:" + id));
        model.addAttribute("movie", movie);
        return "add-rating";
    }

    @GetMapping("/rating/{id}/{movieId}")
    public String showUpdateForm(@PathVariable("id") long id, @PathVariable("movieId") long movieId, Model model) {
        Movie movie = movieService.findById(movieId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid movie Id:" + movieId));
        Rating rating = ratingService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid movie Id:" + id));
        model.addAttribute("movie", movie);
        model.addAttribute("rating", rating);
        return "add-rating";
    }


    @PostMapping("/rating")
    public String addOrUpdateRating(@Valid Rating rating, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-rating";
        }
        Movie movie = movieService.findById(rating.getMovie().getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid movie Id:" + rating.getMovie().getId()));
        ratingService.persist(rating);
        model.addAttribute("movie", movie);
        model.addAttribute("ratings", ratingService.getAll());
        return "ratings";
    }
}
