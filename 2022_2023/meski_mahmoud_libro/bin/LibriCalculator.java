public class LibriCalculator {
    private ArrayList<Libro> libri;
    Scanner in = new Scanner(System.in);

    // Metodo che avvia il programma
    public void start(String nomeFile) throws FileNotFoundException, IOException{
        // Ottiene l'autore in input
        String autore = this.getInput();
        // Descrive l'attività del programma
        this.descriviAttività();
        // Legge i libri da un file
        this.leggiLibriDaFile(nomeFile);
        // Scrive su file i libri
        this.scriviFile();
        // Visualizza i risultati
        this.toString(autore);
    }

    // Metodo che descrive l'attività del programma
    public void descriviAttività(){
        System.out.println("Dico cosa fa il programma :)");
    }

    // Metodo che ottiene l'input dell'autore
    public String getInput(){
        System.out.println("Dimmi il nome dell'autore");
        String autore = in.nextLine();
        return autore;
    }

    // Costruttore della classe che inizializza l'ArrayList di libri
    public LibriCalculator() {
        this.libri = new ArrayList<>();
    }

    // Metodo che legge i libri da un file
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
    
    public void stampaLibri() {
        // stampa tutti i libri presenti nell'ArrayList libri
        for (Libro libro : libri) {
            System.out.println(libro.toString());
        }
    }

    public Libro trovaLibroConNumPagineMaggiore() {
        // inizializza la variabile libroConNumPagineMaggiore a null
        // e numPagineMax a -1
        Libro libroConNumPagineMaggiore = null;
        int numPagineMax = -1;
        // scorri l'ArrayList libri e trova il libro con il numero di pagine maggiore
        for (Libro libro : libri) {
            if (libro.getNumPagine() > numPagineMax) {
                numPagineMax = libro.getNumPagine();
                libroConNumPagineMaggiore = libro;
            }
        }
        // restituisci il libro trovato
        return libroConNumPagineMaggiore;
    }

    public void stampaLibriDiAutore(String autore) {
        // stampa tutti i libri dell'autore passato come parametro autore
        for (Libro libro : libri) {
            if (libro.getAutore().equalsIgnoreCase(autore)) {
                System.out.println(libro.toString());
            }
        }
    }

    public void stampaLibriPerNumPagine() {
        // crea una copia dell'ArrayList libri
        ArrayList<Libro> libriCopia = new ArrayList<>(this.libri);
        // ordina la copia in ordine crescente di numero di pagine
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
        // stampa la copia ordinata
        for (Libro libro : libriCopia) {
            System.out.println(libro);
        }
    }

    public void toString(String autore){
        // stampa tutti i libri presenti nell'ArrayList libri
        System.out.println("I tuoi libri sono");
        this.stampaLibri();
        // stampa i libri ordinati per numero di pagine
        System.out.println("in ordine crescente di pagine");
        this.stampaLibriPerNumPagine();
        // stampa il libro con il numero di pagine maggiore
        System.out.println("il libro con pagine maggiori"+trovaLibroConNumPagineMaggiore());
        // stampa tutti i libri dell'autore passato come parametro autore
        System.out.println("i libri per autore selezionato sono");
        this.stampaLibriDiAutore(autore);
    }
