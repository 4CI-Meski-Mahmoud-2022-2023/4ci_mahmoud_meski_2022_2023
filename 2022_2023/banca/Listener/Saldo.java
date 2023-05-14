package Listener;

import banca.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Saldo implements ActionListener {
    private JComboBox<ContoCorrente> saldoComboBox;
    private JTextArea saldoTextArea;

    public Saldo(JComboBox<ContoCorrente> saldoComboBox, JTextArea saldoTextArea) {
        this.saldoComboBox = saldoComboBox;
        this.saldoTextArea = saldoTextArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ContoCorrente contoCorrente = (ContoCorrente) saldoComboBox.getSelectedItem();
        saldoTextArea.setText("Il saldo del conto corrente di " + contoCorrente.getNomeTitolare() + " " + contoCorrente.getCognomeTitolare() + " è di " + contoCorrente.getSaldo() + " euro.");
    }
}

