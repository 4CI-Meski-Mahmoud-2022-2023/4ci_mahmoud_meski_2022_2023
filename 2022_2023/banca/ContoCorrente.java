public class ContoCorrente {
    private static int ultimoNumeroConto = 0;
    private int numeroConto;
    private String nomeTitolare;
    private String cognomeTitolare;
    private double saldo;

    public ContoCorrente(String nomeTitolare, String cognomeTitolare, double importoIniziale) {
        this.numeroConto = ++ultimoNumeroConto;
        this.nomeTitolare = nomeTitolare;
        this.cognomeTitolare = cognomeTitolare;
        this.saldo = importoIniziale;
    }

    public int getNumeroConto() {
        return numeroConto;
    }

    public String getNomeTitolare() {
        return nomeTitolare;
    }

    public String getCognomeTitolare() {
        return cognomeTitolare;
    }

    public double getSaldo() {
        return saldo;
    }

    public void deposita(double importo) {
        saldo += importo;
    }

    public boolean preleva(double importo) {
        if (saldo < importo) {
            throw new IllegalArgumentException("Saldo insufficiente");
        }
        saldo -= importo;
        return true;
    }


    public void trasferisci(double importo, ContoCorrente contoDestinazione) throws IllegalArgumentException {
        if (importo <= 0) {
            throw new IllegalArgumentException("L'importo del trasferimento deve essere maggiore di zero.");
        }
        if (saldo < importo) {
            throw new IllegalArgumentException("Il saldo del conto corrente non è sufficiente per effettuare il trasferimento.");
        }
        saldo -= importo;
        contoDestinazione.deposita(importo);
    }
    

    @Override
    public String toString() {
        return "Conto " + this.numeroConto + " - " + this.nomeTitolare + " " + this.cognomeTitolare;
    }
}

