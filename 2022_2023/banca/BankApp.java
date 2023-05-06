import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankApp extends JFrame {
    private Banca banca;
    private JTextField nomeField;
    private JTextField cognomeField;
    private JTextField importoField;
    private JComboBox<String> contiComboBox;
    private JTextField importoDaPrelievoField;
    private JTextField importoDaDepositoField;
    private JTextArea saldoTextArea;

    public BankApp() {
        banca = new Banca("Banca di Prova");
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
        apriContoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String cognome = cognomeField.getText();
                double importo = Double.parseDouble(importoField.getText());
                ContoCorrente contoCorrente = new ContoCorrente(nome, cognome, importo);
                banca.aggiungiContoCorrente(contoCorrente);
                contiComboBox.addItem("Conto " + contoCorrente.getNumeroConto());
                JOptionPane.showMessageDialog(BankApp.this, "Conto corrente aperto con successo! Numero di conto: " + contoCorrente.getNumeroConto());
            }
        });
        aperturaContoPanel.add(apriContoButton);

        JPanel depositoPanel = new JPanel();
        depositoPanel.setLayout(new GridLayout(3, 2));
        depositoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        tabbedPane.addTab("Deposito", depositoPanel);

        JLabel contiDepositoLabel = new JLabel("Conti Correnti");
        depositoPanel.add(contiDepositoLabel);
        contiComboBox = new JComboBox<>();
        depositoPanel.add(contiComboBox);
        JLabel importoDepositoLabel = new JLabel("Importo");
        JTextField importoDaDepositoField = new JTextField();
        depositoPanel.add(importoDepositoLabel);
        depositoPanel.add(importoDaDepositoField);

        JButton depositaButton = new JButton("Deposita");
        depositaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = contiComboBox.getSelectedIndex();
                ContoCorrente contoCorrente = banca.getContoCorrente(selectedIndex);
                double importo = Double.parseDouble(importoDaDepositoField.getText());
                contoCorrente.deposita(importo);
                saldoTextArea.setText("Saldo: " + contoCorrente.getSaldo());
                JOptionPane.showMessageDialog(BankApp.this, "Deposito effettuato con successo!");
            }
        });
        depositoPanel.add(depositaButton);

        saldoTextArea = new JTextArea();
        saldoTextArea.setEditable(false);
        depositoPanel.add(saldoTextArea);
        }
    }