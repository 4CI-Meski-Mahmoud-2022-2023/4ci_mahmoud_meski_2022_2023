import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// Dato un nome del file crea un Arraylist con i film
public class FilmReader {

    private ArrayList<Film> films;

    public FilmReader(String fileName) {
        films = new ArrayList<>();
        
        try {
            // Scanner del file
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
                // Legge ogni linea del file
                String line = scanner.nextLine();
                // Divide la linea letta in un array (Le separa quando trova ;)
                String[] tokens = line.split(";");
                // Crea l'oggetto film
                Film film = new Film(tokens[0], tokens[1], tokens[2]);
                // Scrive L'oggetto film nell'ArrayList
                films.add(film);
            }
            scanner.close();
        } catch (FileNotFoundException e)
        // Utilizzato per gestire eventuali eccezioni nel caso in cui il file non possa essere trovato.
        {
            System.out.println("File non trovato");
        }
    }

    public ArrayList<Film> getFilms() {
        return films;
    }

}
