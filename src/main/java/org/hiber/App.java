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
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);

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
        Car car1 = Car.builder().
                model("Shevrole")
                .owner(user)
                .build();
        List<Car> carList = new ArrayList<>();
        carList.add(car);
        user.setCarList(carList);
        userService.addUser(user);
        System.out.println(userService.getAllUsers());
        System.out.println("Список машин пользователя под индексом _ -");
        System.out.println(userService.getCarsByUserId(scanner.nextLong()));
        System.out.println("Какому пользователю вы хотите отдать машину? ");
        userService.addCarToUser(scanner.nextLong(), car1);
        System.out.println("Список машин пользователя под индексом _ -");
        System.out.println(userService.getCarsByUserId(scanner.nextLong()));
        System.out.println("модель машины под индексом _ -");
        System.out.println(userService.getCarByCarId(1L).getModel());
        userService.removeCarFromUser(1L, scanner.nextLong());
        System.out.println("Федералы нашли 12 киллограмм мета в машине ,они её конфисковали на корпаратив");
        System.out.println(userService.getCarsByUserId(scanner.nextLong()));
    }
}
