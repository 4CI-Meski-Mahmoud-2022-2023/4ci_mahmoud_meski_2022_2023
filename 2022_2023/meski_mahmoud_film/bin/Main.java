import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        FilmReader reader = new FilmReader("film.txt");
        ArrayList<Film> films = reader.getFilms();

        // stampa il contenuto dell'ArrayList
        for (Film film : films) {
            System.out.println(film);
        }

        // trova il film con la durata maggiore
        Film longestFilm = Collections.max(films, Comparator.comparing(Film::getDurata));
        System.out.println("Film con durata maggiore: " + longestFilm);

        // stampa i film del regista inserito dall'utente
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci il nome del regista: ");
        String regista = scanner.nextLine();
        for (Film film : films) {
            if (film.getRegista().equalsIgnoreCase(regista)) {
                System.out.println(film);
            }
        }
        scanner.close();

        // ordina i film in base alla durata
        Collections.sort(films, Comparator.comparing(Film::getDurata));
        System.out.println("Film ordinati per durata:");
        for (Film film : films) {
            System.out.println(film);
        }

    }

}
