package banca;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ContiCorrentiPanel extends JPanel {
    private Banca banca;
    private DefaultTableModel tableModel;

    public ContiCorrentiPanel(Banca banca) {
        this.banca = banca;
        String[] columnNames = {"Nome", "Cognome", "Saldo"};
        Object[][] data = new Object[banca.getNumeroConti()][3];
        int i = 0;
        for (ContoCorrente contoCorrente : banca.getContiCorrenti()) {
            data[i][0] = contoCorrente.getNomeTitolare();
            data[i][1] = contoCorrente.getCognomeTitolare();
            data[i][2] = contoCorrente.getSaldo();
            i++;
        }
        tableModel = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }

    public void update() {
        tableModel.setRowCount(0);
        Object[][] data = new Object[banca.getNumeroConti()][3];
        int i = 0;
        for (ContoCorrente contoCorrente : banca.getContiCorrenti()) {
            data[i][0] = contoCorrente.getNomeTitolare();
            data[i][1] = contoCorrente.getCognomeTitolare();
            data[i][2] = contoCorrente.getSaldo();
            i++;
        }
        tableModel.setDataVector(data, new String[]{"Nome", "Cognome", "Saldo"});
    }
}
