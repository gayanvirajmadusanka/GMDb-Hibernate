/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eao;

import entity.UserRatings;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

/**
 *
 * @author Acer
 */
public class RatingEAOImpl implements RatingEAO {

    private SessionFactory sessionFactory;

    public RatingEAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void addRatings(UserRatings userRatings) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(userRatings);
        session.getTransaction().commit();
        session.close();
        System.out.println("Rating was added");
    }

}
