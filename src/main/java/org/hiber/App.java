package org.hiber;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hiber.dao.UserDao;
import org.hiber.dao.UserDaoImpl;
import org.hiber.model.Car;
import org.hiber.model.User;
import org.hiber.service.UserService;
import org.hiber.service.UserServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("user");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        UserDao userDao = new UserDaoImpl(entityManager);
        UserService userService = new UserServiceImpl(userDao);

    }
}
