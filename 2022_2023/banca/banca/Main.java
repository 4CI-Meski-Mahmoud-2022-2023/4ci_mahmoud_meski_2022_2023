package banca;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        Banca banca = new Banca("");
        banca.aggiungiContoCorrente(new ContoCorrente("Mario", " Rossi", 1000.0));
        banca.aggiungiContoCorrente(new ContoCorrente("Luigi", " Verdi", 2000.0));
        banca.aggiungiContoCorrente(new ContoCorrente("Giovanni", " Bianchi", 3000.0));
        
        JFrame frame = new JFrame("Gestione Conti Correnti");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ContiCorrentiPanel contiCorrentiPanel = new ContiCorrentiPanel(banca);
        frame.getContentPane().add(contiCorrentiPanel);
        
        frame.pack();
        frame.setVisible(true);
    }
}
