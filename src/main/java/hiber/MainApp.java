package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Boris","Ivanov","borus@mail.ru");
      Car car1 = new Car("BMW",5);
      user1.setCar(car1);
      car1.setUser(user1);
      userService.add(user1);

      User user2 = new User("Victor","Nicolaev","victor@mail.ru");
      Car car2 = new Car("Lada",2107);
      user2.setCar(car2);
      car2.setUser(user2);
      userService.add(user2);

      User user3 = new User("Mark","Sedov","mark@mail.ru");
      Car car3 = new Car("Toyota Land Cruiser",200);
      user3.setCar(car3);
      car3.setUser(user3);
      userService.add(user3);

      System.out.println(userService.getUserByCarForModelsAndSeries("BMW",5));
      context.close();
   }
}
