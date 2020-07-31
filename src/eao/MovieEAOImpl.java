/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eao;

import entity.Movie;
import entity.User;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

/**
 *
 * @author Acer
 */
public class MovieEAOImpl implements MovieEAO {

    private SessionFactory sessionFactory;

    public MovieEAOImpl() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void create(Movie movie) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(movie);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Movie> searchMovie(String movieName) {
        Session session = sessionFactory.openSession();
        String HQL = "from MOVIE_TAB m where m.MOVIENAME = :name";
        Query query = session.createQuery(HQL);
        query.setParameter("name", movieName);
        List<Movie> movieList = query.list();
        session.close();
        return movieList;
    }

    @Override
    public ArrayList<Movie> getMovies() {
//        String HQL = "FROM MOVIE_TAB";
        Session session = sessionFactory.openSession();
        List<Movie> movieList = session.createCriteria(Movie.class).list();
        session.close();
        return (ArrayList<Movie>) movieList;
    }

}
