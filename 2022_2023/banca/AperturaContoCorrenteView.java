import java.util.Scanner;

public class AperturaContoCorrenteView {
    private Scanner scanner;

    public AperturaContoCorrenteView(Scanner scanner) {
        this.scanner = scanner;
    }

    public ContoCorrente apriContoCorrente() {
        System.out.print("Inserisci il nome del titolare del conto corrente: ");
        String nomeTitolare = scanner.nextLine();
        System.out.print("Inserisci il cognome del titolare del conto corrente: ");
        String cognomeTitolare = scanner.nextLine();
        System.out.print("Inserisci l'importo iniziale del conto corrente: ");
        double importoIniziale = scanner.nextDouble();
        scanner.nextLine();
        return new ContoCorrente(nomeTitolare, cognomeTitolare, importoIniziale);
    }
}
