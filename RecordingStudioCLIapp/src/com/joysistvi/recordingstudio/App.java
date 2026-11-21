import com.joysistvi.recordingstudio.repository.ArtistRepository;
import com.joysistvi.recordingstudio.repository.ArtistRepositoryImpl;
import com.joysistvi.recordingstudio.service.ArtistService;
import com.joysistvi.recordingstudio.service.ArtistServiceImpl;
import com.joysistvi.recordingstudio.view.ArtistView;

public class App {

    public static void main(String[] args) {

        ArtistRepository repository =
                new ArtistRepositoryImpl();

        ArtistService service =
                new ArtistServiceImpl(repository);

        ArtistView view =
                new ArtistView(service);

        view.displayAllArtists();

        // OR test adding artist
        // view.promptCreateArtist();
    }
}