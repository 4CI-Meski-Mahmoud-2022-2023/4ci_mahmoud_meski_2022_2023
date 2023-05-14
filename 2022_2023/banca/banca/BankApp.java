package banca;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Listener.*;

public class BankApp extends JFrame {
    private Banca banca;
    private JTextField nomeField;
    private JTextField cognomeField;
    private JTextField importoField;
    private JComboBox<ContoCorrente> saldoComboBox;
    private JTextArea saldoTextArea;
    private JComboBox<ContoCorrente> depositoComboBox;
    private JTextField importoDaDepositoField;
    private JComboBox<ContoCorrente> prelievoComboBox;
    private JTextField importoDaPrelievoField;
    private JComboBox<ContoCorrente> contoOrigineComboBox = new JComboBox<ContoCorrente>();
    private JComboBox<ContoCorrente> contoDestinazioneComboBox = new JComboBox<ContoCorrente>();
    private JComboBox<ContoCorrente> trasferimentoDaComboBox;
    private JComboBox<ContoCorrente> trasferimentoAComboBox;
    private JTextField importoDaTrasferireField;

    public BankApp() {

        banca = new Banca("Banca di Meski");
        banca.aggiungiContoCorrente(new ContoCorrente("Mario", "Rossi", 1000));
        banca.aggiungiContoCorrente(new ContoCorrente("Luigi", "Bianchi", 2000));
        banca.aggiungiContoCorrente(new ContoCorrente("Carlo", "Verdi", 3000));

        setTitle("Gestione Conti Correnti");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();
        add(tabbedPane, BorderLayout.CENTER);

        JPanel aperturaContoPanel = new JPanel();
        aperturaContoPanel.setLayout(new GridLayout(4, 2));
        aperturaContoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        tabbedPane.addTab("Apertura Conto Corrente", aperturaContoPanel);

        JLabel nomeLabel = new JLabel("Nome");
        aperturaContoPanel.add(nomeLabel);
        nomeField = new JTextField();
        aperturaContoPanel.add(nomeField);

        JLabel cognomeLabel = new JLabel("Cognome");
        aperturaContoPanel.add(cognomeLabel);
        cognomeField = new JTextField();
        aperturaContoPanel.add(cognomeField);

        JLabel importoLabel = new JLabel("Importo iniziale");
        aperturaContoPanel.add(importoLabel);
        importoField = new JTextField();
        aperturaContoPanel.add(importoField);

        JButton apriContoButton = new JButton("Apri Conto");
        AperturaConto ascoltatoreApriConto = new AperturaConto(banca, nomeField, cognomeField, importoField, contoDestinazioneComboBox, contoDestinazioneComboBox, contoDestinazioneComboBox, contoDestinazioneComboBox, contoDestinazioneComboBox);
        apriContoButton.addActionListener(ascoltatoreApriConto);
        aperturaContoPanel.add(apriContoButton);

        JPanel saldoPanel = new JPanel();
        saldoPanel.setLayout(new BorderLayout());
        saldoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        tabbedPane.addTab("Visualizza Saldo", saldoPanel);

        JPanel saldoComboBoxPanel =     new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel saldoComboBoxLabel = new JLabel("Seleziona il conto corrente:");
        saldoComboBoxPanel.add(saldoComboBoxLabel);
        saldoComboBox = new JComboBox<>(banca.getContiCorrenti().toArray(new ContoCorrente[0]));
        saldoComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ContoCorrente conto = (ContoCorrente) saldoComboBox.getSelectedItem();
                saldoTextArea.setText("Il saldo del conto " + conto.getNumeroConto() + " è: " + conto.getSaldo());
            }
        });
        saldoComboBoxPanel.add(saldoComboBox);
        saldoPanel.add(saldoComboBoxPanel, BorderLayout.NORTH);
    
        saldoTextArea = new JTextArea();
        JScrollPane saldoScrollPane = new JScrollPane(saldoTextArea);
        saldoPanel.add(saldoScrollPane, BorderLayout.CENTER);
    
        JPanel depositoPanel = new JPanel();
        depositoPanel.setLayout(new GridLayout(3, 2));
        depositoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        tabbedPane.addTab("Effettua Deposito", depositoPanel);
    
        JLabel depositoComboBoxLabel = new JLabel("Seleziona il conto corrente:");
        depositoPanel.add(depositoComboBoxLabel);
        depositoComboBox = new JComboBox<>(banca.getContiCorrenti().toArray(new ContoCorrente[0]));
        depositoPanel.add(depositoComboBox);
    
        JLabel importoDaDepositoLabel = new JLabel("Importo da depositare:");
        depositoPanel.add(importoDaDepositoLabel);
        importoDaDepositoField = new JTextField();
        depositoPanel.add(importoDaDepositoField);
    
        JButton depositoButton = new JButton("Effettua deposito");
        depositoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ContoCorrente conto = (ContoCorrente) depositoComboBox.getSelectedItem();
                double importo = Double.parseDouble(importoDaDepositoField.getText());
                conto.deposita(importo);
                banca.salvaContiCorrenti();
                saldoTextArea.setText("Il saldo del conto " + conto.getNumeroConto() + " è: " + conto.getSaldo());
            }
        });
        depositoPanel.add(depositoButton);
    
        JPanel prelievoPanel = new JPanel();
        prelievoPanel.setLayout(new GridLayout(3, 2));
        prelievoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        tabbedPane.addTab("Effettua Prelievo", prelievoPanel);
    
        JLabel prelievoComboBoxLabel = new JLabel("Seleziona il conto corrente:");
        prelievoPanel.add(prelievoComboBoxLabel);
        prelievoComboBox = new JComboBox<>(banca.getContiCorrenti().toArray(new ContoCorrente[0]));
        prelievoPanel.add(prelievoComboBox);
    
        JLabel importoDaPrelievoLabel = new JLabel("Importo da prelevare:");
        prelievoPanel.add(importoDaPrelievoLabel);
        importoDaPrelievoField = new JTextField();
        prelievoPanel.add(importoDaPrelievoField);
    
        JButton prelievoButton = new JButton("Effettua prelievo");
        prelievoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ContoCorrente conto = (ContoCorrente) prelievoComboBox.getSelectedItem();
                double importo = Double.parseDouble(importoDaPrelievoField.getText());
                if (conto.getSaldo() < importo) {
                JOptionPane.showMessageDialog(null, "Il saldo del conto non è sufficiente per effettuare il prelievo.");
                } else {
                conto.preleva(importo);
                banca.salvaContiCorrenti();
                saldoTextArea.setText("Il saldo del conto " + conto.getNumeroConto() + " è: " + conto.getSaldo());
                }
                }
                });
                prelievoPanel.add(prelievoButton);

        }

}