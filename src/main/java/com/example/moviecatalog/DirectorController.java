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
public class DirectorController {

    @Autowired
    MovieService movieService;

    @Autowired
    DirectorService directorService;

    @GetMapping("/directors")
    public String getDirectors(Model model) {
        model.addAttribute("directors", directorService.getAll());
        return "directors";
    }

    @GetMapping("/director")
    public String showAddForm(Model model) {
        model.addAttribute("director", new Director());
        return "add-director";
    }

    @GetMapping("/director/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Director director = directorService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid director Id:" + id));
        model.addAttribute("director", director);
        return "add-director";
    }

    @PostMapping("/director")
    public String addOrUpdateDirector(@Valid Director director, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-director";
        }

        directorService.persist(director);
        model.addAttribute("directors", directorService.getAll());
        return "directors";
    }

    @GetMapping("/director/delete/{id}")
    public String deleteDirector(@PathVariable("id") long id, Model model) {
        Director director = directorService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid director Id:" + id));
        director.getMovies().stream().forEach(m -> movieService.remove(m));
        directorService.remove(director);
        model.addAttribute("directors", directorService.getAll());
        return "directors";
    }
}
