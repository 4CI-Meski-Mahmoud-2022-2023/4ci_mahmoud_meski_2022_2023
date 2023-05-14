
package Listener;

import banca.Banca;
import banca.ContoCorrente;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Trasferimento implements ActionListener {
    private Banca banca;
    private JComboBox<ContoCorrente> trasferimentoDaComboBox;
    private JComboBox<ContoCorrente> trasferimentoAComboBox;
    private JTextField importoDaTrasferireField;

    public Trasferimento(Banca banca, JComboBox<ContoCorrente> trasferimentoDaComboBox,
                                    JComboBox<ContoCorrente> trasferimentoAComboBox,
                                    JTextField importoDaTrasferireField) {
        this.banca = banca;
        this.trasferimentoDaComboBox = trasferimentoDaComboBox;
        this.trasferimentoAComboBox = trasferimentoAComboBox;
        this.importoDaTrasferireField = importoDaTrasferireField;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Trasferisci")) {
            ContoCorrente contoOrigine = (ContoCorrente) trasferimentoDaComboBox.getSelectedItem();
            ContoCorrente contoDestinazione = (ContoCorrente) trasferimentoAComboBox.getSelectedItem();
            double importoDaTrasferire = Double.parseDouble(importoDaTrasferireField.getText());
            banca.trasferisci(contoOrigine, contoDestinazione, importoDaTrasferire);
            importoDaTrasferireField.setText("");
        }
    }
}
