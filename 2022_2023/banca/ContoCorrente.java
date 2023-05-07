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

    public void preleva(double importo) {
        if (saldo < importo) {
            throw new IllegalArgumentException("Saldo insufficiente");
        }
        saldo -= importo;
    }
}