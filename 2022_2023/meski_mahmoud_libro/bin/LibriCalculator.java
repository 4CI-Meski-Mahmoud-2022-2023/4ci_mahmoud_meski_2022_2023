import java.util.*;
import java.io.*;
public class LibriCalculator {
    private ArrayList<Libro> libri;
    Scanner in = new Scanner(System.in);
    public void start(String nomeFile) throws FileNotFoundException, IOException{
        String autore = this.getInput();
        this.descriviAttività();
        this.leggiLibriDaFile(nomeFile);
        this.scriviFile();
        this.toString(autore);
    }
    public void descriviAttività(){
        System.out.println("Dico cosa fa il programma :)");
    }
    public String getInput(){
        System.out.println("Dimmi il nome dell'autore");
        String autore = in.nextLine();
        return autore;
    }
    public LibriCalculator() {
        this.libri = new ArrayList<>();
    }
    //
    public void leggiLibriDaFile(String nomeFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(nomeFile));
        while (scanner.hasNextLine()) {
            String linea = scanner.nextLine();
            String[] campi = linea.split(";");
            String titolo = campi[0];
            String autore = campi[1];
            int numPagine = Integer.parseInt(campi[2]);
            Libro libro = new Libro(titolo, autore, numPagine);
            libri.add(libro);
        }
        scanner.close();
    }
    public void scriviFile() throws IOException{
        FileWriter fileOut = new FileWriter("bibliotecaVirtuale.txt");
        for (Libro libro : libri) {
             fileOut.write(libro.toString() + "\n");
        }
        fileOut.close();
    }
    //
    public void stampaLibri() {
        for (Libro libro : libri) {
            System.out.println(libro.toString());
        }
    }
    public Libro trovaLibroConNumPagineMaggiore() {
        Libro libroConNumPagineMaggiore = null;
        int numPagineMax = -1;
        for (Libro libro : libri) {
            if (libro.getNumPagine() > numPagineMax) {
                numPagineMax = libro.getNumPagine();
                libroConNumPagineMaggiore = libro;
            }
        }
        return libroConNumPagineMaggiore;
    }
    public void stampaLibriDiAutore(String autore) {
        for (Libro libro : libri) {
            if (libro.getAutore().equalsIgnoreCase(autore)) {
                System.out.println(libro.toString());
            }
        }
    }
    public void stampaLibriPerNumPagine() {
        ArrayList<Libro> libriCopia = new ArrayList<>(this.libri);
        int n = libriCopia.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (libriCopia.get(j).getNumPagine() > libriCopia.get(j + 1).getNumPagine()) {
                    Libro temp = libriCopia.get(j);
                    libriCopia.set(j, libriCopia.get(j + 1));
                    libriCopia.set(j + 1, temp);
                }
            }
        }
        for (Libro libro : libriCopia) {
            System.out.println(libro);
        }
    }
    public void toString(String autore){
        System.out.println("I tuoi libri sono");
        this.stampaLibri();
        System.out.println("in ordine crescente di pagine");
        this.stampaLibriPerNumPagine();
        System.out.println("il libro con pagine maggiori"+trovaLibroConNumPagineMaggiore());
        System.out.println("i libri per autore selezionato sono");
        this.stampaLibriDiAutore(autore);
    }
}