package banca;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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

    public List<ContoCorrente> getContiCorrenti() {
        return contiCorrenti;
    }
    
    public String getNome() {
        return nome;
    }

    public boolean trasferisci(ContoCorrente contoCorrenteOrigine, ContoCorrente contoCorrenteDestinazione, double importo) {
        contoCorrenteOrigine.preleva(importo);
        contoCorrenteDestinazione.deposita(importo);
        return true;
    }
    
    public boolean deposita(ContoCorrente contoCorrente, double importo) {
        if (importo <= 0) {
            throw new IllegalArgumentException("Importo non valido");
        }
        contoCorrente.deposita(importo);
        return true;
    }
    
    public boolean preleva(ContoCorrente contoCorrente, double importo) {
        if (importo <= 0) {
            throw new IllegalArgumentException("Importo non valido");
        }
        if (contoCorrente.getSaldo() < importo) {
            throw new IllegalArgumentException("Saldo non sufficiente");
        }
        contoCorrente.preleva(importo);
        return true;
    }

public int getNumeroConti() {
    return contiCorrenti.size();
}

public void salvaContiCorrenti() {
    try {
        FileOutputStream file = new FileOutputStream("conti_correnti.txt");
        ObjectOutputStream out = new ObjectOutputStream(file);
        out.writeObject(contiCorrenti);
        out.close();
        file.close();
        System.out.println("I conti correnti sono stati salvati correttamente.");
    } catch (IOException e) {
        System.out.println("Si è verificato un errore durante il salvataggio dei conti correnti.");
        e.printStackTrace();
    }
}

}
