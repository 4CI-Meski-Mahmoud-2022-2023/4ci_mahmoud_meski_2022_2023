package Listener;

import banca.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Deposito implements ActionListener {
    private JComboBox<ContoCorrente> depositoComboBox;
    private JTextField importoDaDepositoField;
    private JComboBox<ContoCorrente> saldoComboBox;

    public Deposito(JComboBox<ContoCorrente> depositoComboBox, JTextField importoDaDepositoField, JComboBox<ContoCorrente> saldoComboBox) {
        this.depositoComboBox = depositoComboBox;
        this.importoDaDepositoField = importoDaDepositoField;
        this.saldoComboBox = saldoComboBox;
    }

    public void actionPerformed(ActionEvent e) {
        ContoCorrente contoCorrente = (ContoCorrente) depositoComboBox.getSelectedItem();
        double importo = Double.parseDouble(importoDaDepositoField.getText());
        try {
            contoCorrente.deposita(importo);
            JOptionPane.showMessageDialog(null, "Deposito di " + importo + " euro effettuato con successo sul conto corrente di " + contoCorrente.getNomeTitolare() + " " + contoCorrente.getCognomeTitolare());
            importoDaDepositoField.setText("");
            saldoComboBox.setSelectedItem(contoCorrente);
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }
}
