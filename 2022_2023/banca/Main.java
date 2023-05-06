import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Banca banca = new Banca("Banca di Prova");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Cosa vuoi fare?");
            System.out.println("1. Aprire un conto corrente");
            System.out.println("2. Effettuare un deposito");
            System.out.println("3. Effettuare un prelievo");
            System.out.println("4. Visualizzare il saldo di un conto corrente");
            System.out.println("5. Uscire");

            int scelta = scanner.nextInt();

            switch (scelta) {
                case 1:
                    AperturaContoCorrenteView aperturaContoCorrenteView = new AperturaContoCorrenteView(scanner);
                    ContoCorrente contoCorrente = aperturaContoCorrenteView.apriContoCorrente();
                    banca.aggiungiContoCorrente(contoCorrente);
                    System.out.println("Conto corrente aperto con successo! Numero di conto: " + contoCorrente.getNumeroConto());
                    break;

                case 2:
                    System.out.print("Inserisci il numero di conto corrente: ");
                    int numeroConto = scanner.nextInt();
                    ContoCorrente contoCorrenteDaDeposito = banca.getContoCorrente(numeroConto);
                    System.out.print("Inserisci l'importo da depositare: ");
                    double importoDaDeposito = scanner.nextDouble();
                    contoCorrenteDaDeposito.deposita(importoDaDeposito);
                    System.out.println("Deposito effettuato con successo! Nuovo saldo: " + contoCorrenteDaDeposito.getSaldo());
                    break;

                case 3:
                    System.out.print("Inserisci il numero di conto corrente: ");
                    int numeroContoDaPrelievo = scanner.nextInt();
                    ContoCorrente contoCorrenteDaPrelievo = banca.getContoCorrente(numeroContoDaPrelievo);
                    System.out.print("Inserisci l'importo da prelevare: ");
                    double importoDaPrelievo = scanner.nextDouble();
                    try {
                        contoCorrenteDaPrelievo.preleva(importoDaPrelievo);
                        System.out.println("Prelievo effettuato con successo! Nuovo saldo: " + contoCorrenteDaPrelievo.getSaldo());
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Inserisci il numero di conto corrente: ");
                    int numeroContoDaVisualizzare = scanner.nextInt();
                    ContoCorrente contoCorrenteDaVisualizzare = banca.getContoCorrente(numeroContoDaVisualizzare);
                    System.out.println("Saldo attuale: " + contoCorrenteDaVisualizzare.getSaldo());
                    break;

                case 5:
                    System.out.println("Grazie per aver utilizzato i nostri servizi!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Scelta non valida");
            }

            System.out.println();
        }
    }
}
