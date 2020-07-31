/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eao;

import entity.User;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

/**
 *
 * @author Acer
 */
public class UserEAOImpl implements UserEAO {

    private SessionFactory sessionFactory;

    public UserEAOImpl() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void create(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
//        session.persist(user);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public User getSpecificUser(String userName, String userPassword) {
//        String HQL = "FROM USER_TAB WHERE username = :username";
        String HQL = "FROM USER_TAB e WHERE e.USERNAME = :user_name";
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(HQL);
        query.setParameter("user_name", userName);
        User user = (User) query.uniqueResult();
        session.close();
        return user;
    }

    @Override
    public List<User> getAllUsers() {
//        String HQL = "FROM USER_TAB";
        Session session = sessionFactory.openSession();
        List<User> userList = session.createCriteria(User.class).list();
        session.close();
        return userList;
    }

}
