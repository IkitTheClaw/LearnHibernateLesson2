package org.hiber.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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
    }

    public void saveUser(User user) {

    }

    public void removeCarFromUser(Long userId, Long carId) {

    }

    public List<User> getAllUsers() {
        return null;
    }

    public User getUserById(Long id) {
        return null;
    }

    public List<Car> getCarsByUserId(Long userId) {
        return null;
    }

    public Car getCarById(Long id) {
        return null;
    }
}
