package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.hibernate.Session;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        Car carUser1 = new Car("BMW", 3);
        Car carUser2 = new Car("Mercedes", 5);
        Car carUser3 = new Car("Lexus", 7);

        User user1 = new User("Ivan", "Petrov", "ivanpetrov@mail.ru");
        user1.setCar(carUser1);

        User user2 = new User("Alexander", "Vasilenko", "alexvas@mail.ru");
        user2.setCar(carUser2);

        User user3 = new User("Stas", "Dusiak", "stasdusiak@mail.ru");
        user3.setCar(carUser3);

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);


        userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru"));


        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar());
            System.out.println();
        }
        context.close();
    }
}
