package com.example.moviecatalog.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Movie Name is mandatory")
    private String name;

    @ManyToOne
    @JoinColumn(name="director_id", nullable=false)
    private Director director;

    @OneToMany(mappedBy = "movie")
    private Set<Rating> ratings;

    public long getId() {
        return id;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
    }

    public Set<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(Set<Rating> ratings) {
        this.ratings = ratings;
    }

    public double getAverageRating() {
        return null == ratings ? 0 : ratings.stream().mapToInt(r -> r.getPercentageRating()).average().orElse(0);
    }
}
