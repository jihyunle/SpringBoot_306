package com.example.demo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String genre;

    @OneToMany(mappedBy = "director", cascade = CascadeType.ALL, fetch = FetchType.EAGER) // we attach this annot to a set of movies
    public Set<Movie> movies; // now each director comes with their own collection of movies

    /* We use Set b/c 1) it allows each element to exist only once. 2) order doesn't matter in sets
    *
    * mappedBy tells the set of movies where to save the data. AKA the director class is the keeper of the movie set.
    * mappedBy="director" tells the persistence provider that the join column should be in the Director table
    **/

    public Director() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}
