package com.example.moviecatalog;

import com.example.moviecatalog.model.Movie;

import com.example.moviecatalog.service.DirectorService;
import com.example.moviecatalog.service.MovieService;
import com.example.moviecatalog.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class MovieController {

    @Autowired
    MovieService movieService;

    @Autowired
    DirectorService directorService;

    @Autowired
    RatingService ratingService;

    @GetMapping("/movie")
    public String showForm(Model model)
    {
        model.addAttribute("directors", directorService.getAll());
        model.addAttribute("movie", new Movie());
        return "add-movie";
    }


    @RequestMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("movies", movieService.getAll());
        return "index";
    }
     
    @PostMapping("/movie")
    public String addOrUpdateMovie(@Valid Movie movie, BindingResult result, Model model) {
        model.addAttribute("directors", directorService.getAll());
        if (result.hasErrors()) {
            return "add-movie";
        }
         
        movieService.persist(movie);
        model.addAttribute("movies", movieService.getAll());
        return "index";
    }

    @GetMapping("/movie/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Movie movie = movieService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid movie Id:" + id));

        model.addAttribute("directors", directorService.getAll());
        model.addAttribute("movie", movie);
        model.addAttribute("ratings", ratingService.getAll());

        return "add-movie";
    }

    @GetMapping("/movie/delete/{id}")
    public String deleteMovie(@PathVariable("id") long id, Model model) {
        Movie movie = movieService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid movie Id:" + id));
        movie.getRatings().stream().forEach(r -> ratingService.remove(r));
        movieService.remove(movie);
        model.addAttribute("movies", movieService.getAll());
        return "index";
    }
}