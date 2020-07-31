/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Acer
 */
@Entity
@Table(name = "MOVIE_TAB") 
public class Movie implements Serializable {
    private int movieId;
    private int movieYear;
    private String movieName;
    private String movieDirectors;
    private String movieActors;
    private String movieRuntime;

    private List<Genre> genresList;
    private List<UserRatings> userRatingsList;
    
    
    public Movie() {
        genresList = new ArrayList<>();
        userRatingsList = new ArrayList<>();
    }

    public Movie(int movieYear, String movieName, String movieDirectors, String movieActors, String movieRuntime) {
        this();
        this.movieYear = movieYear;
        this.movieName = movieName;
        this.movieDirectors = movieDirectors;
        this.movieActors = movieActors;
        this.movieRuntime = movieRuntime;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(int movieYear) {
        this.movieYear = movieYear;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDirectors() {
        return movieDirectors;
    }

    public void setMovieDirectors(String movieDirectors) {
        this.movieDirectors = movieDirectors;
    }

    public String getMovieActors() {
        return movieActors;
    }

    public void setMovieActors(String movieActors) {
        this.movieActors = movieActors;
    }

    public String getMovieRuntime() {
        return movieRuntime;
    }

    public void setMovieRuntime(String movieRuntime) {
        this.movieRuntime = movieRuntime;
    }

    @ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinTable(name = "MOVIE_GENRE_TAB",
            joinColumns = {@JoinColumn(name = "id")},
            inverseJoinColumns={@JoinColumn(name="genreId")})
    public List<Genre> getGenresList() {
        return genresList;
    }

    public void setGenresList(List<Genre> genresList) {
        this.genresList = genresList;
    }

    @OneToMany(mappedBy = "movie")
//    @OneToMany(mappedBy = "MOVIE_TAB")
    public List<UserRatings> getUserRatingsList() {
        return userRatingsList;
    }

    public void setUserRatingsList(List<UserRatings> userRatingsList) {
        this.userRatingsList = userRatingsList;
    }
    
    
    
    
    
}
