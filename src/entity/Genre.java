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
import javax.persistence.Table;

/**
 *
 * @author Acer
 */
@Entity
@Table(name = "GENRE_TAB")
public class Genre implements Serializable {

    private int genreId;
    private String genres;

    private List<Movie> moviesList;

    public Genre() {
        moviesList = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(name = "MOVIE_GENRE_TAB",
            joinColumns = {
                @JoinColumn(name = "genreId")},
            inverseJoinColumns = {
                @JoinColumn(name = "id")})
    public List<Movie> getMoviesList() {
        return moviesList;
    }

    public void setMoviesList(List<Movie> moviesList) {
        this.moviesList = moviesList;
    }

}
