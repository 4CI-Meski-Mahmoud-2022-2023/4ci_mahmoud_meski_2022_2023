package Listener;

import banca.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AperturaConto implements ActionListener {
    private Banca banca;
    private JTextField nomeField;
    private JTextField cognomeField;
    private JTextField importoField;
    private JComboBox<ContoCorrente> saldoComboBox;
    private JComboBox<ContoCorrente> depositoComboBox;
    private JComboBox<ContoCorrente> prelievoComboBox;
    private JComboBox<ContoCorrente> trasferimentoDaComboBox;
    private JComboBox<ContoCorrente> trasferimentoAComboBox;

    public AperturaConto(Banca banca, JTextField nomeField, JTextField cognomeField, JTextField importoField,
                         JComboBox<ContoCorrente> saldoComboBox, JComboBox<ContoCorrente> depositoComboBox,
                         JComboBox<ContoCorrente> prelievoComboBox, JComboBox<ContoCorrente> trasferimentoDaComboBox,
                         JComboBox<ContoCorrente> trasferimentoAComboBox) {
        this.banca = banca;
        this.nomeField = nomeField;
        this.cognomeField = cognomeField;
        this.importoField = importoField;
        this.saldoComboBox = saldoComboBox;
        this.depositoComboBox = depositoComboBox;
        this.prelievoComboBox = prelievoComboBox;
        this.trasferimentoDaComboBox = trasferimentoDaComboBox;
        this.trasferimentoAComboBox = trasferimentoAComboBox;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nome = nomeField.getText();
        String cognome = cognomeField.getText();
        double importo = 0.0;
        try {
            importo = Double.parseDouble(importoField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Importo non valido");
            return;
        }
        ContoCorrente contoCorrente = new ContoCorrente(nome, cognome, importo);
        banca.aggiungiContoCorrente(contoCorrente);
        saldoComboBox.addItem(contoCorrente);
        depositoComboBox.addItem(contoCorrente);
        prelievoComboBox.addItem(contoCorrente);
        trasferimentoDaComboBox.addItem(contoCorrente);
        trasferimentoAComboBox.addItem(contoCorrente);
        JOptionPane.showMessageDialog(null, "Conto corrente aperto con successo!");
    }
}
