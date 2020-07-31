/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Acer
 */
@Entity
@Table(name = "USER_RATINGS_TAB")
public class UserRatings implements Serializable {

    private int userRatingId;
    private int userRatingValue;

    private Movie movie;

    public UserRatings() {
    }

    public UserRatings(int userRatingValue) {
        this.userRatingValue = userRatingValue;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getUserRatingId() {
        return userRatingId;
    }

    public void setUserRatingId(int userRatingId) {
        this.userRatingId = userRatingId;
    }

    public int getUserRatingValue() {
        return userRatingValue;
    }

    public void setUserRatingValue(int userRatingValue) {
        this.userRatingValue = userRatingValue;
    }

    @ManyToOne
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    
    
    
    

}
