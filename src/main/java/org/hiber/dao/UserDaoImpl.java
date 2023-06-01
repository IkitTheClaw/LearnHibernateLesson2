package org.hiber.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.hiber.model.Car;
import org.hiber.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private final EntityManager entityManager;

    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void addCarToUser(Long userId, Car car) {
        entityManager.getTransaction().begin();
        entityManager.find(User.class,userId);
        entityManager.merge(car);
        entityManager.persist(entityManager.find(User.class,userId));
        entityManager.getTransaction().commit();

    }

    @Override
    public void saveUser(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public void removeCarFromUser(Long carId) {
        entityManager.getTransaction().begin();
        Car car = entityManager.find(Car.class, carId);
        User user = entityManager.find(User.class,car);
        entityManager.remove(car);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList;
        String sql = "FROM User";

        Query query = entityManager.createQuery(sql);
        entityManager.getTransaction().begin();
        userList = query.getResultList();
        entityManager.getTransaction().commit();
        return userList;
    }

    public User getUserById(Long id) {
        User user;
        entityManager.getTransaction().begin();
        user = entityManager.find(User.class, id);
        entityManager.getTransaction().commit();
        return user;
    }

    public List<Car> getCarsByUserId(Long userId) {
        Car car ;
        entityManager.getTransaction().begin();
        car = entityManager.find(Car.class,userId);
        entityManager.getTransaction().commit();
        return null;
    }

    public Car getCarById(Long id) {
        entityManager.getTransaction().begin();
        Car searchedCar = entityManager.find(Car.class, id);
        entityManager.getTransaction().commit();
        return searchedCar;
    }
}
