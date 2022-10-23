package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"), new Car("BMW", 68685));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"), new Car("Ford", 345));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"), new Car("Ford", 1234));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"), new Car("Mercedes", 56804));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);
         System.out.println();
      }

      User user = userService.getUserOwnCar("Ford", 1234);
      System.out.println(user);

      context.close();
   }
}
