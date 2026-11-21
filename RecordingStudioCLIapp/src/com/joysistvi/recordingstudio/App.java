import com.joysistvi.recordingstudio.repository.UserRepository;
import com.joysistvi.recordingstudio.repository.UserRepositoryImpl;
import com.joysistvi.recordingstudio.service.UserService;
import com.joysistvi.recordingstudio.service.UserServiceImpl;
import com.joysistvi.recordingstudio.view.UserView;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n*** User ***");
        System.out.println("[1] Register");
        System.out.println("[2] Login");
        System.out.println("[0] Exit");
        System.out.print("\nEnter your choice: ");

        int choice = sc.nextInt();
        sc.nextLine(); // Consume leftover newline

        switch (choice) {

            case 1:
                UserService userService = new UserServiceImpl();
                userService.createUser(
                        "Juan Dela Cruz",
                        "juan",
                        "password123"
                );
                break;

            case 2:
                System.out.println("login");
                break;

            case 0:
                System.out.println("good bye");
                break;

            default:
                System.out.println("thankyou");
                break;


        }

    }
}