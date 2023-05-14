package Listener;

import banca.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Prelievo implements ActionListener {
    private JComboBox<ContoCorrente> prelievoComboBox;
    private JTextField importoDaPrelievoField;
    private JComboBox<ContoCorrente> saldoComboBox;

    public Prelievo(JComboBox<ContoCorrente> prelievoComboBox, JTextField importoDaPrelievoField, JComboBox<ContoCorrente> saldoComboBox) {
        this.prelievoComboBox = prelievoComboBox;
        this.importoDaPrelievoField = importoDaPrelievoField;
        this.saldoComboBox = saldoComboBox;
    }

    public void actionPerformed(ActionEvent e) {
        ContoCorrente contoCorrente = (ContoCorrente) prelievoComboBox.getSelectedItem();
        double importo = Double.parseDouble(importoDaPrelievoField.getText());
        try {
            contoCorrente.preleva(importo);
            JOptionPane.showMessageDialog(null, "Prelievo di " + importo + " euro effettuato con successo dal conto corrente di " + contoCorrente.getNomeTitolare() + " " + contoCorrente.getCognomeTitolare());
            importoDaPrelievoField.setText("");
            saldoComboBox.setSelectedItem(contoCorrente);
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }
}
