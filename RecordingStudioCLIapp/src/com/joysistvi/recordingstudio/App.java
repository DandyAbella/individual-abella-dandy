import com.joysistvi.recordingstudio.repository.UserRepository;
import com.joysistvi.recordingstudio.repository.UserRepositoryImpl;
import com.joysistvi.recordingstudio.service.UserService;
import com.joysistvi.recordingstudio.service.UserServiceImpl;
import com.joysistvi.recordingstudio.view.UserView;

public class App {

    public static void main(String[] args) {

        UserRepository repository =
                new UserRepositoryImpl();

        UserService service =
                new UserServiceImpl(repository);

        UserView view =
                new UserView(service);

        view.displayAllUsers();
    }
}