import java.util.ArrayList;
import java.util.List;

public class Banca {

    private String nome;
    private List<ContoCorrente> contiCorrenti;

    public Banca(String nome) {
        this.nome = nome;
        this.contiCorrenti = new ArrayList<>();
    }

    public void aggiungiContoCorrente(ContoCorrente contoCorrente) {
        contiCorrenti.add(contoCorrente);
    }

    public ContoCorrente getContoCorrente(int numeroConto) {
        for (ContoCorrente contoCorrente : contiCorrenti) {
            if (contoCorrente.getNumeroConto() == numeroConto) {
                return contoCorrente;
            }
        }
        throw new IllegalArgumentException("Conto corrente non trovato");
    }
}
