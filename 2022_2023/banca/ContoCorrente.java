public class ContoCorrente {
    private static int prossimoNumeroConto = 1;

    private String nomeIntestatario;
    private String cognomeIntestatario;
    private int numeroConto;
    private double saldo;

    public ContoCorrente(String nomeIntestatario, String cognomeIntestatario, double saldoIniziale) {
        this.nomeIntestatario = nomeIntestatario;
        this.cognomeIntestatario = cognomeIntestatario;
        this.numeroConto = prossimoNumeroConto;
        this.saldo = saldoIniziale;
        prossimoNumeroConto++;
    }

    public void deposita(double importo) {
        saldo += importo;
    }

    public void preleva(double importo) {
        if (importo > saldo) {
            throw new IllegalArgumentException("Saldo insufficiente");
        }
        saldo -= importo;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getNumeroConto() {
        return numeroConto;
    }

    @Override
    public String toString() {
        return "ContoCorrente [nomeIntestatario=" + nomeIntestatario + ", numeroConto=" + numeroConto + ", saldo=" + saldo + "]";
    }
}
