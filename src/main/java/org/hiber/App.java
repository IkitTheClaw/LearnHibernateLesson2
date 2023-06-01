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

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        UserDao userDao = new UserDaoImpl(entityManager);
        UserService userService = new UserServiceImpl(userDao);

        //userService.getAllUsers().stream().forEach(System.out::println);
        User user = User.builder()
                .firstName("Johny")
                .lastName("McCevin")
                .email("@@@bitch")
                .build();
        Car car = Car.builder()
                .model("Mustang")
                .owner(user)
                .build();
        List<Car> carList = new ArrayList<>();
        carList.add(car);
        user.setCarList(carList);
        userService.addUser(user);
        System.out.println(userService.getAllUsers());
       // Car car1 = Car.builder()
        //        .model("Shevrole")
        //        .owner(user)
         //       .build();
    }
}
