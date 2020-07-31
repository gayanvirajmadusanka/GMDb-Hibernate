/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eao;

import entity.Movie;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer
 */
public interface MovieEAO {

    void create(Movie movie);

    List<Movie> searchMovie(String movieName);

    ArrayList<Movie> getMovies();
}
