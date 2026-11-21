import com.joysistvi.recordingstudio.RegisterUser;
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
                UserRepository userRepository = new UserRepositoryImpl();
                UserService userService = new UserServiceImpl(userRepository);

                System.out.print("\nEnter full name: ");
                String full_name = sc.nextLine();

                System.out.print("Enter user name: ");
                String user_name = sc.nextLine();

                System.out.print("Enter user password: ");
                String user_password = sc.nextLine();

                userService.createUser(
                        full_name,
                        user_name,
                        user_password
                );
                break;

            case 2:
                UserRepository userRepository = new UserRepositoryImpl();
                UserService userService = new UserServiceImpl(userRepository);

                System.out.print("User Name: ");
                String username = sc.nextLine().trim();

                System.out.print("Password: ");
                String password = sc.nextLine().trim();


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