package main;

import eao.MovieEAO;
import eao.MovieEAOImpl;
import eao.UserEAO;
import eao.UserEAOImpl;
import entity.Genre;
import entity.Movie;
import entity.User;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Add a new user
        UserEAO userEAO = new UserEAOImpl();

        //Add user one
        User user = new User();
        user.setUserName("Viraj");
        user.setUserPassword("Viraj1234");
        userEAO.create(user);

        //Add user two
        User user2 = new User();
        user2.setUserName("Gayan");
        user2.setUserPassword("Gayan1222");
        userEAO.create(user2);

        //Add movie 1
        Movie movie1 = new Movie(2020, "Greyhound", "Aaron Schneider", " Tom Hanks, Elisabeth Shue, Stephen Graham", "91");
        Genre genre1 = new Genre();
        genre1.setGenres("Action");
        movie1.getGenresList().add(genre1);

        //Add movie 2
        Movie movie2 = new Movie(2020, "Dark", " Baran bo Odar, Jantje Friese", "Louis Hofmann, Karoline Eichhorn, Lisa Vicari", "60");
        Genre genre2 = new Genre();
        genre2.setGenres("Action");
        movie2.getGenresList().add(genre2);

        MovieEAO movieEAO = new MovieEAOImpl();
        movieEAO.create(movie1);
        movieEAO.create(movie2);

        //Get users list 
        List<User> allUsers = userEAO.getAllUsers();
        System.out.println("Users List : ");
        for (User allUser : allUsers) {
            System.out.println("\t" + allUser.getUserName());
        }

        //Get movie list 
        List<Movie> allMovies = movieEAO.getMovies();
        System.out.println("Movie List : ");
        for (Movie allMovie : allMovies) {
            System.out.println("\t" + allMovie.getMovieName());
        }
        //Get a movie
//        List<Movie> movie = movieEAO.searchMovie("Dark");
//        for (Movie mov : movie) {
//            System.out.println("Movie Name : " + mov.getMovieName());
//        }

        //Get a user 
        User userx = userEAO.getSpecificUser("Gayan", "000");
        System.out.println(userx.getUserName());
    }
}
