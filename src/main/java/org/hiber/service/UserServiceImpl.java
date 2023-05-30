package org.hiber.service;

import org.hiber.dao.UserDao;
import org.hiber.model.Car;
import org.hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService{

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public void addCarToUser(Long userId, Car car) {

    }
    @Override
    public void addUser(User user) {

    }
    @Override
    public void removeCarFromUser(Long userId, Long carId) {

    }

    @Override
    public void removeCar(Long carId) {

    }

    @Override
    public void removeUser(Long userId) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public List<Car> getCarsByUserId(Long userId) {
        return null;
    }

    @Override
    public Car getCarByCarId(Long id) {
        return null;
    }
}
