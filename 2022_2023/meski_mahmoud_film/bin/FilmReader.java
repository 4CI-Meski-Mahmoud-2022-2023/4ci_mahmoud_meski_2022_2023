import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FilmReader {

    private ArrayList<Film> films;

    public FilmReader(String fileName) {
        films = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(";");
                Film film = new Film(tokens[0], tokens[1], tokens[2]);
                films.add(film);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File non trovato");
        }
    }

    public ArrayList<Film> getFilms() {
        return films;
    }

}
