package org.hiber.service;

import org.hiber.model.Car;
import org.hiber.model.User;

import java.util.List;

public interface UserService {
    void addCarToUser(Long userId, Car car);

    void addUser(User user);

    void removeCarFromUser(Long carId,Long userId);

    void removeCar(Long carId,Long userId);

    void removeUser(Long userId);

    List<User> getAllUsers();

    User getUserById(Long id);

    List<Car> getCarsByUserId(Long userId);

    Car getCarByCarId(Long id);
}
